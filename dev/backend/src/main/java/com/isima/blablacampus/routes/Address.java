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
	private Integer id;
	
	@Column(name = "\"Longitude\"")
	private double longitude;
	
	@Column(name = "\"Latitude\"")
	private double latitude;
	
	@Column(name = "\"Address\"")
	private String Address;
	
	
	
	public Address() {
	
	}


	public Address(double longitude, double latitude, String Address) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.Address = Address;
	}





	public Integer getId() {
		return id;
	}



	public double getLongitude() {
		return longitude;
	}



	public double getLatitude() {
		return latitude;
	}



	public String getAddress() {
		return Address;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public void setLineAddress(String Address) {
		this.Address = Address;
	}
	

	
	

}
