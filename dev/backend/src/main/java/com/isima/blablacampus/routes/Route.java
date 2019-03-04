package com.isima.blablacampus.routes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="\"Routes\"")
public class Route {
	
	@Id
	@Column(name="\"Id\"")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="\"StartingPoint\"")
	private Place startingPoint;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="\"EndPoint\"")
	private Place endPoint;
	
	@OneToMany(mappedBy="route", cascade=CascadeType.ALL)
	private List<Ride> rides;
	

	public Route() {
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Place getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(Place startingPoint) {
		this.startingPoint = startingPoint;
	}

	public Place getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Place endPoint) {
		this.endPoint = endPoint;
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}
	
}
