package com.isima.blablacampus.routes;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isima.blablacampus.security.model.User;

@Entity()
@Table(name="\"Rides\"")
public class Ride {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"Id\"")
	private Integer id;
	
	@Column(name="\"Date\"")
	private Date date;
	
	@Column(name="\"Active\"")
	private boolean active;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="\"Route\"")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="\"Driver\"")
	private User driver;
	
	@Column(name="\"AvailableSeats\"")
	private int availableSeats;
	

	public Ride() {
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@JsonIgnore
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}
