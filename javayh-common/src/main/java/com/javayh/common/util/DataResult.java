package com.javayh.common.util;

import lombok.Data;

@Data
public class DataResult<T> {
	private int code;// 错误码
	private T data;// 数据
	private String msg;// 错误提示

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


	private DataResult(T data, Boolean flushToken) {
		this.code=1;
		this.data=data;
	}

	private DataResult(int code, String msg, Boolean flushToken) {
		this.code=code;
		this.msg=msg;
	}

	private DataResult(int code, String msg, Boolean flushToken, T data) {
		this.code=code;
		this.msg=msg;
		this.data=data;
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


}
