package com.javayh.api.serviceimpl;

import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.entity.UserRole;
import com.javayh.conf.mapper.UserMapper;
import com.javayh.conf.mapper.UserRoleMapper;
import com.javayh.conf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName javayh-distribution
 * @Description UserServiceImpl
 * @Author Dylan
 * @Date 2019/10/29 17:01
 * @Version
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * @Description 根据用户名查询用户信息
	 * @UserModule: javayh-distribution
	 * @author Dylan
	 * @date 2019/10/30
	 * @param username
	 * @return com.javayh.conf.dto.SysUserDTO
	 */
	public SysUserDTO getUserByName(String username) {
		return userMapper.selectUserByName(username);
	}

	@Override
	public List<SysUser> getAllPageUser() {
		return  userMapper.getAllPageUser();
	}

}
