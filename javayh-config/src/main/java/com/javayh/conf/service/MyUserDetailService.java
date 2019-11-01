package com.javayh.conf.service;

import com.javayh.conf.dto.RoleDTO;
import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.entity.Role;
import com.javayh.conf.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserService userService;
	@Autowired
    private SessionRegistry sessionRegistry;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		if (username == null || username.equals("")) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		SysUserDTO user = userService.getUserByName(username);
		if (user == null || user.equals("")) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		// 获得所有登录用户的信息
		List<Object> list = sessionRegistry.getAllPrincipals();
		// 得到当前登录用户的信息  将得到的角色封装 在后面页面认证成功后会用到
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (RoleDTO role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			log.info("拥有的角色{}",role.getRoleName());
		}
		return new User(user.getUserName(), user.getPassWord(), authorities);
	}

}
