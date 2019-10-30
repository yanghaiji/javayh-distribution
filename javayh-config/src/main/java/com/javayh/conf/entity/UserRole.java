package com.javayh.conf.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer roleId;
}
