package com.isima.blablacampus.routes.exceptions;

public class PlaceAlreadyExistException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	
	public PlaceAlreadyExistException(String message) {
		super(message);
	}
	
	public PlaceAlreadyExistException() {
		super();
	}

}
