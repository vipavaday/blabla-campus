package com.isima.blablacampus.routes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="\"Places\"")
public class Place {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "\"Id\"")
	private Integer placeId;
	
	@Column(name = "\"Name\"")
	private String name;
	
	@Column(name = "\"Description\"")
	private String description;
	
	@Column(name = "\"StudyingPlace\"")
	private boolean studyingPlace;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"AddressId\"")
	private Address address;
	

	public Place() {
		
	}
	

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStudyingPlace() {
		return studyingPlace;
	}

	public void setStudyingPlace(boolean studyingPlace) {
		this.studyingPlace = studyingPlace;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
