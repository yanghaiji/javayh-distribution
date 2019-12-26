package com.javayh.conf.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName javayh-distribution → com.javayh.conf.dto → SysUserDTO
 * @Description
 * @Author Dylan
 * @Date 2019/10/30 12:51
 * @Version
 */
@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String passWord;
    private String active;
    private String email;
    private Date createDate;
    private String phone;
    /*0 正常 1 锁定*/
    private Integer status;
    private Integer tryCount;
    private Set<RoleDTO> roles = new HashSet<>();
}
