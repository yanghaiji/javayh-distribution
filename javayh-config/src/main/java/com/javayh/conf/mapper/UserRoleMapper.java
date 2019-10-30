package com.javayh.conf.mapper;


import com.javayh.conf.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserRoleMapper {
			

	int insertUser_role(UserRole userRole);
	
	
	void deleteUser_role(Integer uid);
	
}
