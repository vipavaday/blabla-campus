package com.isima.blablacampus.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.isima.blablacampus.security.services.impl.UserService;


public class AppAuthProvider extends DaoAuthenticationProvider {
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        
        String name = auth.getName(); 
        
        UserDetails user = userDetailsService.loadUserByUsername(name);
        
        if (user == null) {
        	
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
            
        }else if(!user.isEnabled()) {
        	
        	throw new DisabledException("User account not activated, please check your emails.");
        }

        boolean passwordsMatch = pwdEncoder.matches(auth.getCredentials().toString() ,  user.getPassword());
        
        if(!passwordsMatch) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        
        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	
}
