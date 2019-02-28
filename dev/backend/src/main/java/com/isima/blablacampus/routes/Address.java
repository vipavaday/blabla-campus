package com.isima.blablacampus.routes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Locations\"")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name = "\"Id\"")
	private int id;
	
	@Column(name = "\"Longitude\"")
	private double longitude;
	
	@Column(name = "\"Latitude\"")
	private double latitude;
	
	@Column(name = "\"Address\"")
	private String address;
	
	
	public Address() {
	
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

}
