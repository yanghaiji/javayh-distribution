package com.javayh.conf.service;

import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.dto.UserModfiyPwdDTO;
import com.javayh.conf.entity.SysUser;

import java.util.List;

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

	/**
	 * 查询用户
	 * @return
	 */
    List<SysUser> getAllPageUser();

    /**
     * @Description 新增用户
     * @UserModule: javayh-distribution
     * @author Dylan
     * @date 2019/10/31
     * @param user
     * @return void
     */
    int saveUser(SysUser user);

    /**
     * @Description 修改用户信息
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/11/1
     * @param user
     * @return void
     */
    void updateUser(SysUser user);

	/**
	 * @Description 删除用户
	 * @UserModule: exam-web-paper
	 * @author Dylan
	 * @date 2019/11/1
	 * @param id
	 * @return void
	 */
    void delete(int id);

	int updateUserPwd(UserModfiyPwdDTO user);
}
