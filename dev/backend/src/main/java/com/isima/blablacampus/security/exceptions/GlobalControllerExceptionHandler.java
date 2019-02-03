package com.isima.blablacampus.security.exceptions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	private static final Logger logger =  LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> methodNotAllowed(HttpRequestMethodNotSupportedException e){
		
		logger.error(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("");
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<FieldError>> badUser(MethodArgumentNotValidException e){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getBindingResult().getFieldErrors());
	}
	
	@ExceptionHandler(AccountStatusException.class)
	public ResponseEntity<String> disabledUser(AccountStatusException e){
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
}
