package com.javayh.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class DataResult<T> {
	private int code;// 错误码
	private T data;// 数据
	private String msg;// 错误提示
	private Boolean flushToken; //是否需要刷新jwt  true 刷新， false 不刷新

	public DataResult(int code, T data) {
		this.code = code;
		this.data = data;
	}

	public DataResult(int code) {
		this.code = code;
	}

	private DataResult(){
		// jsonObject parseObject的时候默认调用的是空参构造，所以留下此方法
	}

	private DataResult(Boolean flushToken) {
		this.flushToken=flushToken;
	}

	private DataResult(T data, Boolean flushToken) {
		this.code=1;
		this.data=data;
		this.flushToken=flushToken;
	}

	private DataResult(int code, String msg, Boolean flushToken) {
		this.code=code;
		this.msg=msg;
		this.flushToken=flushToken;
	}

	private DataResult(int code, String msg, Boolean flushToken, T data) {
		this.code=code;
		this.msg=msg;
		this.data=data;
		this.flushToken=flushToken;
	}

	public static <T> DataResult<T> success(T data) {
		return new DataResult(1,data);
	}

	public static <T> DataResult<T> success() {
		return new DataResult(1);
	}

	public static <T> DataResult<T> error() {
		return new DataResult(0);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getFlushToken() { return flushToken;}

	public void setFlushToken(Boolean flushToken) { this.flushToken = flushToken;}

}
