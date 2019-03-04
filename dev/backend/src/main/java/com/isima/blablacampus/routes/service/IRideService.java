package com.isima.blablacampus.routes.service;

import java.util.List;

import com.isima.blablacampus.routes.Ride;

public interface IRideService {
	
	public void saveRide(Ride ride);
	public void saveAllRides(List<Ride> rides);

}
