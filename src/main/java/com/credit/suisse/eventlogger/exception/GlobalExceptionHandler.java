package com.credit.suisse.eventlogger.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ServiceException handleGlobalException(Exception e) {
		ServiceException se = new ServiceException();
		se.setErrorCode("ERR-01");
		se.setErrorDescription(e.getMessage());
		return se;
	}
}
