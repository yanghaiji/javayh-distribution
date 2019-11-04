package com.javayh.conf.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName javayh-distribution → com.javayh.conf.dto → SysUserSerchDTO
 * @Description
 * @Author Dylan
 * @Date 2019/11/4 12:56
 * @Version
 */
@Data
public class SysUserSerchDTO implements Serializable {
    private String userName;
    private String email;
    private String phone;
}
