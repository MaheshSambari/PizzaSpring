package com.pizzaapplication.exception;

public class ErrorMessage {
	
	private Integer errorCode;
	private String errorCodeDescription;
	private String message;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorCodeDescription() {
		return errorCodeDescription;
	}
	public void setErrorCodeDescription(String errorCodeDescription) {
		this.errorCodeDescription = errorCodeDescription;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String errorMessage) {
		this.message = errorMessage;
	}
	
}
