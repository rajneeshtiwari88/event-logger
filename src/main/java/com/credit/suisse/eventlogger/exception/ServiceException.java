package com.credit.suisse.eventlogger.exception;

public class ServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private String errorDescription;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	
	
	

}
