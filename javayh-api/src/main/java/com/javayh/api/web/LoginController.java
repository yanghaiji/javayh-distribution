package com.javayh.api.web;

import com.javayh.common.tree.TreeNode;
import com.javayh.conf.aop.OperationType;
import com.javayh.conf.aop.WebLogAspect;
import com.javayh.conf.service.MyUserDetailService;
import com.javayh.conf.service.SysMenuService;
import com.javayh.conf.service.UserService;
import com.javayh.conf.util.UserUtils;
import com.javayh.conf.util.log.ApplicationType;
import com.javayh.conf.util.log.OperationType;
import com.javayh.conf.util.log.WebLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private SessionRegistry sessionRegistry;
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	/**
	 * @Description 登录
	 * @UserModule: exam-web-paper
	 * @author Dylan
	 * @date 2019/10/30
	 * @param model
	 * @return java.lang.String
	 */
	@RequestMapping("/index")
	@WebLogAspect(detail = "Java有货登录", operationType = OperationType.LOGIN, applicationType = ApplicationType.WEB)
	public String index(Model model) {
		response.setContentType("application/json");
		String username=request.getUserPrincipal().getName();
		List<TreeNode> list = sysMenuService.findList(UserUtils.getRoleId());
		log.info("登录用户{}",username);
		model.addAttribute("menulist", list);
		model.addAttribute("username", username);
		return "index";
	}


	/**
	 * 注销时直接从sessionRegistry中移除请求中储存的sessionid
	 * @return
	 */
	@RequestMapping("/mylogout")
	@WebLogAspect(detail = "Java有货退出登录", operationType = OperationType.LOGOUT, applicationType = ApplicationType.WEB)
	public String logout2() {
		String sessionid=request.getRequestedSessionId();
		sessionRegistry.removeSessionInformation(sessionid);
		return "redirect:/login";
	}


}
