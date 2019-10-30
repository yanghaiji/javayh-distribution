package com.javayh.conf.util;

import com.javayh.common.util.SpringContextHolder;
import com.javayh.conf.mapper.UserMapper;
import com.javayh.conf.vo.UserNameRoleVO;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
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
     * @param request 
     * @return java.lang.String
     */
    public static String getUserName(HttpServletRequest request){
        String username=request.getUserPrincipal().getName();
        return username;
    }

    /**
     * @Description 获取登录用户角色
     * @UserModule: exam-web-paper       
     * @author Dylan
     * @date 2019/10/30
     * @param request 
     * @return java.util.List<com.javayh.conf.vo.UserNameRoleVO>
     */
    public static List<UserNameRoleVO>  getRole(HttpServletRequest request){
        String userName = getUserName(request);
        List<UserNameRoleVO> userNameRoleVOS = userMapper.selectRoleByName(userName);
        return userNameRoleVOS;
    }

    /**
     * @Description 获取角色id
     * @UserModule: exam-web-paper       
     * @author Dylan
     * @date 2019/10/30
     * @param request 
     * @return java.util.List<java.lang.String>
     */
    public static List<String>  getRoleId(HttpServletRequest request){
        String userName = getUserName(request);
        List<String> userNameRoleVOS = userMapper.selectRoleIdByName(userName);
        return userNameRoleVOS;
    }

}

