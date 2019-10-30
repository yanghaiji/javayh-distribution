package com.javayh.conf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	/*角色名称*/
	private String roleName;
	/*创建时间*/
	private Date createDate;
	private Date updateDate;
	private String createBy;
	private String updateBy;

}
