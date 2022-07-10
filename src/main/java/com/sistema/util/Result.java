package com.sistema.util;

public class Result {
	
	String status;
	Object data;
	String error_code;
	String error_description;	
	
	public Result(String status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	public Result(String status, String errCode, String errDescr) {
		this.status = status;
		this.error_code = errCode;
		this.error_description = errDescr;
	}
	
	public Result(String status, String errCode, String errDescr, Object data) {
		this.status = status;
		this.error_code = errCode;
		this.error_description = errDescr;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

}
