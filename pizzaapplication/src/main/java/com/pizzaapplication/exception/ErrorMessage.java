package com.pizzaapplication.exception;

public class ErrorMessage {
	
	private Integer errorCode;
	private String errorCodeDescription;
	private String errorMessage;
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
