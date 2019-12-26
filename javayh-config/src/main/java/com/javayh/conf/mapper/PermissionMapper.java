package com.javayh.conf.mapper;

import com.javayh.conf.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

/*    public int insertPer(Permission permission);

    public int deletePerById(Integer id);

    public int updateper(Permission permission);*/

    public List<Permission> selectAllper();

    public List<Permission> getPerByUserId(int id);


}
