package com.javayh.api.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description: 用户相关操作
 * @ProjectName javayh-distribution
 * @date 2019-10-30 23:22
 */
@Controller
@RequestMapping("/touser")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 来到添加用户页面
     * @return
     */
    @RequestMapping("/adduser")
    public String touser() {
        return "user/register";
    }

    @GetMapping("/alluser_admin")
    public String getAllUser(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 4);
        List<SysUser> u_list = userService.getAllPageUser();
        PageInfo<SysUser> page = new PageInfo<>(u_list, 3);
        model.addAttribute("pageInfo", page);
        return "user/users";
    }
}
