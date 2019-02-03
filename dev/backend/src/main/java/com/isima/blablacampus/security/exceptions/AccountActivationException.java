package com.isima.blablacampus.security.exceptions;

import org.springframework.http.HttpStatus;

public class AccountActivationException extends Exception {

	
	private static final long serialVersionUID = -2408752176267059959L;
	
	private String message;
	
	private HttpStatus status;
	

	public AccountActivationException(String message) {
		
		this(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	public AccountActivationException(String message, HttpStatus status) {
		
		this.message = message;
		this.status = status;
	}


	@Override
	public String getMessage() {
		
		return message;
	}


	public HttpStatus getStatus() {
		return status;
	}
}
