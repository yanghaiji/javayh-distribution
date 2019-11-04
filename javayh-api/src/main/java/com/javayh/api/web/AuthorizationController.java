package com.javayh.api.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName javayh-distribution → com.javayh.api.web → AuthorizationController
 * @Description 授权页面
 * @Author Dylan
 * @Date 2019/11/4 10:59
 * @Version
 */
@Slf4j
@Controller
@RequestMapping(value = "/javayh/")
public class AuthorizationController {

    @RequestMapping("/tosetpermission_admin")
    public String getAllUser() {
        return "authorization/authorization";
    }
}
