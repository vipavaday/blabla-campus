package com.isima.blablacampus.security.utils;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.isima.blablacampus.security.model.User;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = -2055750889426091997L;

	private String appUrl;
	   
	   private Locale locale;
	   
	   private User user;
	   
	 
	   public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
	        super(user);
	         
	        this.user = user;
	        this.locale = locale;
	        this.appUrl = appUrl;
	   }


	public String getAppUrl() {
		return appUrl;
	}


	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}


	public Locale getLocale() {
		return locale;
	}


	public void setLocale(Locale locale) {
		this.locale = locale;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
