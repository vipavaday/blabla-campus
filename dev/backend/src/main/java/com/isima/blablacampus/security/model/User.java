package com.isima.blablacampus.security.model;


import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.isima.blablacampus.routes.Ride;
import com.isima.blablacampus.security.model.validation.ValidPassword;

@Entity
@Table(name="\"Users\"")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 7943547775228079786L;
	
	@Id
	@GeneratedValue
	@Column(name = "\"Id\"")
	private Integer userId;
	
	@Column(name = "\"Firstname\"")
	@NotBlank
	private String firstname;
	
	@Column(name = "\"Lastname\"")
	@NotBlank
	private String lastname;
	
	@Column(name = "\"Email\"")
	@Email
	private String email;
	
	@ValidPassword
	@Transient
	private String rawPassword;
	
	@Column(name = "\"Password\"")
	@JsonIgnore
	private String passwordHash;

	@Column(name = "\"Phone\"")
	private String phone;
	
	@Column(name = "\"Pic\"")
	private String picPath;
	
	@OneToMany(mappedBy="driver")
	private List<Ride> submittedRides;
	
	@Column(name = "\"Locked\"")
	private boolean locked;
	
	@Column(name = "\"Active\"")
	private boolean active;


	
	public User() {
		
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	@JsonIgnore
	public List<Ride> getSubmittedRides() {
		return submittedRides;
	}

	public void setSubmittedRides(List<Ride> submittedRides) {
		this.submittedRides = submittedRides;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	@JsonProperty(value="password")
	public void setRawPassword(String password) {
		this.rawPassword = password;
	}

	@JsonIgnore
	public String getRawPassword() {
		return rawPassword;
	}
	
	@JsonIgnore
	@Override
	public String getPassword() {
		return passwordHash;
	}

	public void setPassword(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		
		return active;
	}
	
	public void setEnabled(boolean enabled) {
		
		this.active = enabled;
	}


	public String getUsername() {
		return email;
	}

}
