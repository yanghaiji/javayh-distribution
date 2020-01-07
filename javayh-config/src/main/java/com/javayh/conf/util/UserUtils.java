package com.javayh.conf.util;

import com.javayh.common.util.SpringContextHolder;
import com.javayh.conf.mapper.UserMapper;
import com.javayh.conf.vo.UserNameRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.xml.ws.WebServiceContext;
import java.util.List;

/**
 * @ClassName javayh-distribution → com.javayh.common.user → UserUtils
 * @Description 获取登录人信息
 * @Author Dylan
 * @Date 2019/10/30 14:49
 * @Version
 */
public class UserUtils {

    private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    /**
     * @Description 获取登录名
     * @UserModule: exam-web-paper       
     * @author Dylan
     * @date 2019/10/30
     * @return java.lang.String
     */
    public static String getUserName(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username=request.getUserPrincipal().getName();
        return username;
    }

    /**
     * @Description 获取登录用户角色
     * @UserModule: exam-web-paper       
     * @author Dylan
     * @date 2019/10/30
     * @return java.util.List<com.javayh.conf.vo.UserNameRoleVO>
     */
    public static List<UserNameRoleVO>  getRole(){
        String userName = getUserName();
        List<UserNameRoleVO> userNameRoleVOS = userMapper.selectRoleByName(userName);
        return userNameRoleVOS;
    }

    /**
     * @Description 获取角色id
     * @UserModule: exam-web-paper       
     * @author Dylan
     * @date 2019/10/30
     * @return java.util.List<java.lang.String>
     */
    public static List<String>  getRoleId(){
        String userName = getUserName();
        List<String> userNameRoleVOS = userMapper.selectRoleIdByName(userName);
        return userNameRoleVOS;
    }

}

