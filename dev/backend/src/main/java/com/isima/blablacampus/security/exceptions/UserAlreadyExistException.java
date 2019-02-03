package com.isima.blablacampus.security.exceptions;

public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1140402158329534092L;
	
	private String email;
	
	public UserAlreadyExistException(String email) {
		super();
		this.email = email;
	}

	@Override
	public String getMessage() {
		
		return "There is an account with that email address: " + email;
	}
	
	
	
}
