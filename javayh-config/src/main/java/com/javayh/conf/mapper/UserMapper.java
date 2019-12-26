package com.javayh.conf.mapper;


import com.javayh.common.mybatis.mapper.BaseMapper;
import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.dto.SysUserSerchDTO;
import com.javayh.conf.dto.UserModfiyPwdDTO;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.vo.UserNameRoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

    /**
     * @param username
     * @return com.javayh.conf.entity.SysUser
     * @Description 根据用户名查询用户信息
     * @UserModule: javayh-distribution
     * @author Dylan
     * @date 2019/10/30
     */
    SysUserDTO selectUserByName(String username);


    /**
     * @param userName
     * @return java.util.List<com.javayh.conf.vo.UserNameRoleVO>
     * @Description 获取角色信息
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/30
     */
    List<UserNameRoleVO> selectRoleByName(String userName);

    /**
     * @param userName
     * @return java.util.List<java.lang.String>
     * @Description 获取角色id
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/30
     */
    List<String> selectRoleIdByName(String userName);

    List<SysUser> getAllPageUser(SysUserSerchDTO dto);

    /**
     * @param id
     * @return
     * @Description 获取角色id
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/30
     */
    void updateDelFlag(int id);

    void updateInfo(SysUser user);

    void updatePwd(UserModfiyPwdDTO user);
}
