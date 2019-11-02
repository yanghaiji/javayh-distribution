package com.javayh.api.serviceimpl;

import com.javayh.common.mybatis.service.BaseService;
import com.javayh.common.util.DataResult;
import com.javayh.common.util.MD5Util;
import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.dto.UserModfiyPwdDTO;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.entity.UserRole;
import com.javayh.conf.mapper.UserMapper;
import com.javayh.conf.mapper.UserRoleMapper;
import com.javayh.conf.service.UserService;
import com.javayh.conf.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName javayh-distribution
 * @Description UserServiceImpl
 * @Author Dylan
 * @Date 2019/10/29 17:01
 * @Version
 */
@Service
public class UserServiceImpl extends BaseService<SysUser> implements UserService {

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

	/**
	 * @Description 列表查询
	 * @UserModule: javayh-distribution
	 * @author Dylan
	 * @date 2019/10/31
	 * @param
	 * @return java.util.List<com.javayh.conf.entity.SysUser>
	 */
	@Override
	public List<SysUser> getAllPageUser() {
		return  userMapper.getAllPageUser();
	}

	/***
	 * @Description 新增用户
	 * @UserModule: javayh-distribution
	 * @author Dylan
	 * @date 2019/10/31
	 * @param user
	 * @return void
	 */
	@Override
	public int saveUser(SysUser user) {
		SysUserDTO sysUserDTO = userMapper.selectUserByName(user.getUserName());
		if(sysUserDTO!= null){
			return 0;
		}
		//密码加密  以及初始状态设置
		String password = "123456";
		user.setPassWord(MD5Util.encode(password));
		user.setActive("活跃");//初始注册人员状态全部为活跃状态
		user.setCreateDate(new Date());
		this.save(user);
		return 1;
	}

	/**
	 * @Description 修改用户信息
	 * @UserModule: exam-web-paper
	 * @author Dylan
	 * @date 2019/11/1
	 * @param user
	 * @return void
	 */
	@Override
	public void updateUser(SysUser user) {
		user.setUpdateDate(new Date());
		userMapper.updateInfo(user);
	}

	@Override
	public void delete(int id) {
		userMapper.updateDelFlag(id);
	}

	@Override
	public int updateUserPwd(UserModfiyPwdDTO user) {
		//密码加密  以及初始状态设置
		String lodPwd = MD5Util.encode(user.getLodPwd());
		SysUser byId = super.findById(user.getId());
		if(lodPwd.equals(byId.getPassWord())){
			String password=user.getNewPwd();
			user.setNewPwd(MD5Util.encode(password));
			user.setUpdateDate(new Date());
			userMapper.updatePwd(user);
			return 1;
		}
		return 0;
	}

}
