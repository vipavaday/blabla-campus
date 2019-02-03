package com.isima.blablacampus.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isima.blablacampus.security.exceptions.AccountActivationException;
import com.isima.blablacampus.security.exceptions.UserAlreadyExistException;
import com.isima.blablacampus.security.model.User;
import com.isima.blablacampus.security.model.VerificationToken;
import com.isima.blablacampus.security.services.impl.UserService;
import com.isima.blablacampus.security.utils.OnRegistrationCompleteEvent;

@RestController
public class SecurityController {
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(path="/user/register", method=RequestMethod.POST)
	public ResponseEntity<User> createUserAccount(@RequestBody @Valid User u, HttpServletRequest request) throws UserAlreadyExistException, AccountActivationException{
		
		userService.registerNewUserAccount(u);
		
		try {
			String appUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
	        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(u, request.getLocale(), appUrl));
	        
		}catch(Exception e){
			throw new AccountActivationException("Failed to send account activation email");
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
	}
	
	
	@RequestMapping(value = "/user/registrationConfirm", method = RequestMethod.GET)
	public ResponseEntity<User> confirmRegistration(@RequestParam(name="token") String token) throws AccountActivationException {
		
		VerificationToken retrievedToken = userService.getUserToken(token);
		
		User tokenOwner = retrievedToken.getUser();
		
		if(retrievedToken.getExpirationDate().getTime() < new Date().getTime() ) {
			throw new AccountActivationException("Invalid token");
		}
		
		tokenOwner.setEnabled(true);
		userService.activateUserAccount(tokenOwner);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tokenOwner);
	}
	
	@RequestMapping(path="/user/status", method=RequestMethod.GET)
	public ResponseEntity<User> getUserStatus(HttpServletRequest request){
		
		String login = request.getUserPrincipal().getName();
		User u = userService.loadUserByUsername(login);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
	}
	
	@RequestMapping(path="/user/authFailure", method=RequestMethod.GET)
	public ResponseEntity<String> getError(@RequestParam(name="error") String error){

		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}
	
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> userAlreadyExistHandler(UserAlreadyExistException e){
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(AccountActivationException.class)
	public ResponseEntity<String> serverFailureHandler(AccountActivationException e){
		
		return ResponseEntity.status(e.getStatus()).body(e.getMessage());
	}
}
