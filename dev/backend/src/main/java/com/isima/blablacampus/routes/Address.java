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
	
	@Column(name = "\"RoadNb\"")
	private int roadNumber;
	
	@Column(name = "\"RoadName\"")
	private String roadName;
	
	@Column(name = "\"ZIPCode\"")
	private int zipCode;
	
	@Column(name = "\"City\"")
	private String city;
	
	
	public Address() {
	
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoadNumber() {
		return roadNumber;
	}

	public void setRoadNumber(int roadNumber) {
		this.roadNumber = roadNumber;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

}
