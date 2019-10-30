package com.javayh.conf.mvc;

import com.javayh.conf.entity.SysUser;
import com.javayh.conf.mapper.UserMapper;
import es.moki.ratelimitj.core.limiter.request.RequestLimitRule;
import es.moki.ratelimitj.core.limiter.request.RequestRateLimiter;
import es.moki.ratelimitj.inmemory.request.InMemorySlidingWindowRequestRateLimiter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @ClassName javayh-distribution → com.javayh.conf.mvc → LoginFailureListener
 * @Description
 * @Author Dylan
 * @Date 2019/10/29 13:26
 * @Version
 */
@Component
public class LoginFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    //错误了第四次返回true,然后锁定账号,第五次即使密码正确也会报账户锁定
    Set<RequestLimitRule> rules = Collections.singleton(RequestLimitRule.of(10, TimeUnit.MINUTES,3)); // 3 request per 10 minute, per key
    RequestRateLimiter limiter = new InMemorySlidingWindowRequestRateLimiter(rules);

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        if (event.getException().getClass().equals(UsernameNotFoundException.class)) {
            return;
        }

        String userId = event.getAuthentication().getName();

        boolean reachLimit = limiter.overLimitWhenIncremented(userId);

        if(reachLimit){
            User user = (User) userDetailsService.loadUserByUsername(userId);
            System.out.println(user);
//            SysUser updated = new User(user.getUsername(),user.getPassword(),user.isEnabled(),user.isAccountNonExpired(),user.isAccountNonExpired(),false,user.getAuthorities());
//
//            userDetailsManager.updateUser(updated);
        }
    }
}

