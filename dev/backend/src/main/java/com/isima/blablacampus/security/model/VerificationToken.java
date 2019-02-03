package com.isima.blablacampus.security.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="\"VerificationToken\"")
public class VerificationToken {
	
	private static final int EXPIRATION = 60 * 24;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="\"Id\"")
    private int id;
    
    @Column(name="\"Token\"")
    private String token;
   
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "\"UserId\"")
    private User user;
    
    @Column(name="\"ExpirationDate\"")
    private Date expirationDate;
    
    
    public VerificationToken() {
    	
	}
    
    
    public VerificationToken(User user, String token) {
    	
		this.token = token;
		this.user = user;
		this.expirationDate = calculateExpiryDate(EXPIRATION);
	}
    

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
    	
        Calendar cal = Calendar.getInstance();
        
        cal.setTime(new Date(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        
        return new Date(cal.getTime().getTime());
    }
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
    

}
