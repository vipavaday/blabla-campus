package com.isima.blablacampus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.isima.blablacampus.security.services.impl.UserService;
import com.isima.blablacampus.security.utils.AppAuthProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private UserService userService;
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.authenticationProvider(getProvider());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(new Http403ForbiddenEntryPoint() {
        })
        .and()
        .authenticationProvider(getProvider())
        .formLogin()
        .loginProcessingUrl("/user/login")
        .successHandler(new AuthentificationLoginSuccessHandler())
        .failureHandler(new AuthentificationLoginFailureHandler("/user/authFailure"))
        .and()
        .logout()
        .logoutUrl("/user/logout")
        .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
        .invalidateHttpSession(true)
        .and()
        .authorizeRequests()
        .antMatchers("/user/login", "/user/logout", "/user/register", "/user/registrationConfirm", "/user/authFailure").permitAll()
        .anyRequest().authenticated();
}

    @Bean
    public AuthenticationProvider getProvider() {
    	
        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userService);
        
        return provider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    
    private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
    
    private class AuthentificationLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    	
    	public AuthentificationLoginFailureHandler(String defaultFailureUrl) {
    		
			super(defaultFailureUrl);
    	}

		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			
			response.sendRedirect("/user/authFailure?error="+exception.getMessage());
		}
    	
    	
    }
    
    private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
        
    	@Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
