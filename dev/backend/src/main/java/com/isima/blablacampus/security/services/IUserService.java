package com.isima.blablacampus.security.services;

import com.isima.blablacampus.security.exceptions.AccountActivationException;
import com.isima.blablacampus.security.exceptions.UserAlreadyExistException;
import com.isima.blablacampus.security.model.User;
import com.isima.blablacampus.security.model.VerificationToken;

public interface IUserService {
	
	User registerNewUserAccount(User user) throws UserAlreadyExistException;

	void createVerificationToken(User user, String token);
	
	VerificationToken getUserToken(String token) throws AccountActivationException;

	void activateUserAccount(User tokenOwner);
}
