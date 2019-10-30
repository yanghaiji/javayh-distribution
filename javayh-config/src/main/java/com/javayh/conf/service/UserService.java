package com.javayh.conf.service;

import com.javayh.conf.dto.SysUserDTO;

public interface UserService {

	/**
	 * @Description 根据用户名查询用户信息
	 * @UserModule: javayh-distribution
	 * @author Dylan
	 * @date 2019/10/30
	 * @param username
	 * @return com.javayh.conf.dto.SysUserDTO
	 */
	SysUserDTO getUserByName(String username);

}
