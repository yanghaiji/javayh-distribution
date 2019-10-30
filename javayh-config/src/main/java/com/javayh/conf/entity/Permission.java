package com.javayh.conf.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String permissionName ;
	private String description;
	private String url;

}
