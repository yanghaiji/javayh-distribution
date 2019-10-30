package com.javayh.conf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String passWord;
	private Date createDate;
	private Date updateDate;
	private String active;
	private String email;
	/*0 正常 1 锁定*/
	private Integer status;
	private Integer tryCount;
	private String phone;

}
