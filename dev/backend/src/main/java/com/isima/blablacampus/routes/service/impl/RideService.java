package com.isima.blablacampus.routes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isima.blablacampus.routes.Ride;
import com.isima.blablacampus.routes.service.IRideService;
import com.isima.blablacampus.routes.service.RideRepository;

@Service
public class RideService implements IRideService{
	
	@Autowired
	private RideRepository rideRepository;
	@Autowired
	private RouteService routeService;
	
	

	@Override
	public void saveRide(Ride ride) {
		
		rideRepository.save(ride);
		
	}



	@Override
	public void saveAllRides(List<Ride> rides) {
		
		if(rides != null) {
			
			for(Ride ride: rides) {
				
				List<Ride> savedRides = rideRepository.findAllByDate(ride.getDate());
				
				if(savedRides != null) {
					
					boolean found = false;
					
					int i = 0;
					
					while(!found && i < savedRides.size()) {
						
						if(!(savedRides.get(i).getDriver().getEmail().equals(ride.getDriver().getEmail()) && 
								savedRides.get(i).getRoute().getStartingPoint().getName().equals(ride.getRoute().getStartingPoint().getName()) &&
								savedRides.get(i).getRoute().getEndPoint().getName().equals(ride.getRoute().getEndPoint().getName()) &&
								savedRides.get(i).getAvailableSeats() == ride.getAvailableSeats())) {
							
							++i;
							
						}else {
							
							found = true;
						}
					}
					
					if(!found) {
						
						routeService.saveRoute(ride.getRoute());
						
						rideRepository.save(ride);
						
					}
					
				}else {
					
					
					rideRepository.save(ride);
					
				}
				
			}			
			
		}
		
		
		
	}
	
	

}
