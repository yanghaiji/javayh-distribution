package com.javayh.conf.mapper;


import com.javayh.common.mybatis.mapper.BaseMapper;
import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.vo.UserNameRoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

	/**
	 * @Description 根据用户名查询用户信息
	 * @UserModule: javayh-distribution
	 * @author Dylan
	 * @date 2019/10/30
	 * @param username
	 * @return com.javayh.conf.entity.SysUser
	 */
	SysUserDTO selectUserByName(String username);


	/**
	 * @Description 获取角色信息
	 * @UserModule: exam-web-paper
	 * @author Dylan
	 * @date 2019/10/30
	 * @param userName
	 * @return java.util.List<com.javayh.conf.vo.UserNameRoleVO>
	 */
    List<UserNameRoleVO> selectRoleByName(String userName);

    /**
     * @Description 获取角色id
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/30
     * @param userName
     * @return java.util.List<java.lang.String>
     */
    List<String> selectRoleIdByName(String userName);

	List<SysUser> getAllPageUser();
}
