package com.isima.blablacampus.security.model;

public class Connection {
	
	private String email;
	private String password;
	
	
	
	public Connection() {}
	public Connection(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	

}
