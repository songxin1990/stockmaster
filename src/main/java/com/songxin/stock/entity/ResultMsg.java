package com.songxin.stock.entity;

import java.io.Serializable;


public class ResultMsg implements Serializable {

	private static final long serialVersionUID = 7656591030450820150L;

	private boolean isError;
	
	private String errorMsg;

	public ResultMsg(String errorMsg) {
		this.isError = true;
		this.errorMsg = errorMsg;
	}

	public ResultMsg(boolean isError, String errorMsg) {
		this.isError = isError;
		this.errorMsg = errorMsg;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

