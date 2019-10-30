package com.javayh.conf.mapper;


import com.javayh.conf.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RoleMapper {
	
	int insertRole(Role role);
	
	int deleteRoById(Integer id);
	
	int updateRole(Role role);
	
	List<Role> selectAllRole();
	
	Role getRoleById(Integer id);
	
	Role selectAllPsByRole(String rolename);
	

}
