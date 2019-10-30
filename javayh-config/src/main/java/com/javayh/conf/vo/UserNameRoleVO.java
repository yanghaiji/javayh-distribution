package com.javayh.conf.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName javayh-distribution → com.javayh.conf.vo → UserNameRoleVO
 * @Description
 * @Author Dylan
 * @Date 2019/10/30 15:14
 * @Version
 */
@Data
public class UserNameRoleVO implements Serializable {
    private Integer id;
    private String roleName;
}
