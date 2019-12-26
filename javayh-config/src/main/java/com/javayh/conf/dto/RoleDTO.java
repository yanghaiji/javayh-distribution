package com.javayh.conf.dto;

import com.javayh.conf.entity.Permission;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String roleName;
    private Set<Permission> permissions = new HashSet<>();

}
