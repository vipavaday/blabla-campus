package com.isima.blablacampus.security.services.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isima.blablacampus.routes.Ride;
import com.isima.blablacampus.security.exceptions.AccountActivationException;
import com.isima.blablacampus.security.exceptions.UserAlreadyExistException;
import com.isima.blablacampus.security.model.User;
import com.isima.blablacampus.security.model.VerificationToken;
import com.isima.blablacampus.security.services.IUserService;
import com.isima.blablacampus.security.services.UserRepository;
import com.isima.blablacampus.security.services.VerificationTokenRepository;

@Service
public class UserService implements UserDetailsService, IUserService {
	
	
    private final UserRepository userRepository;
    
    private final VerificationTokenRepository tokenRepo;
    
	@Autowired
	private PasswordEncoder pwdEncoder;
    
  
    @Autowired
    public UserService(UserRepository userRepository, VerificationTokenRepository tokenRepo) {
    	
        this.userRepository = userRepository;
        this.tokenRepo = tokenRepo;
    }

    
    
	@Override
	public User loadUserByUsername(String userLogin) throws UsernameNotFoundException {
		
		Objects.requireNonNull(userLogin);
        User user = userRepository.findByEmail(userLogin)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
	}

	
	@Override
	public User registerNewUserAccount(User user) throws UserAlreadyExistException {
		
		if(emailExist(user.getEmail())) {
			throw new UserAlreadyExistException(user.getEmail());
		}
		
		user.setPassword(pwdEncoder.encode(user.getRawPassword()));
		
		return userRepository.save(user);
	}
	
	
	private boolean emailExist(final String email) {
		
        return userRepository.findByEmail(email).isPresent();
    }

	
	@Override
	public void createVerificationToken(User user, String token) {
		
		VerificationToken v = new VerificationToken(user, token);
		tokenRepo.save(v);
	}


	@Override
	public VerificationToken getUserToken(String token) throws AccountActivationException {
		
		return tokenRepo.findByToken(token)
				.orElseThrow(()-> new AccountActivationException("Bad user"));
	}


	@Override
	public void activateUserAccount(User tokenOwner) {
		
		userRepository.save(tokenOwner);
	}



	@Override
	public void saveUserRide(Ride ride) {
		
		userRepository.
		findById(ride.getDriver().getUserId()).get().
		getSubmittedRides().add(ride);
		
	}

}
