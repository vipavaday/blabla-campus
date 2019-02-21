package com.isima.blablacampus.routes.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isima.blablacampus.routes.Ride;
import com.isima.blablacampus.routes.Route;
import com.isima.blablacampus.routes.service.IRouteService;
import com.isima.blablacampus.routes.service.RouteRepository;



@Service
public class RouteService implements IRouteService{
	
	private final RouteRepository routeRepository;
	
	
	
	
	@Autowired
	public RouteService(RouteRepository routeRepository) {
		
		this.routeRepository = routeRepository;
		
	}




	@Override
	public List<Route> loadUserRoutes(List<Ride> rides) {
		
		//Récupérer les itinéraires
		List<Route> routes = null;
		
		if(rides !=null && rides.size() > 0) {
			
			Iterator<Ride> itRide = rides.iterator();
			
			routes = new ArrayList<Route>();
			
			Ride ride = itRide.next();
			
			Route route = ride.getRoute();
			
			routes.add(route);
			
			while(itRide.hasNext()) {
				
				ride = itRide.next();
				
				Iterator<Route> itRoute = routes.iterator();
				
				route = itRoute.next();
				
				while(ride.getRoute().getId() != route.getId()  && itRoute.hasNext()) {
					
					route = itRoute.next();
					
				}
				
				if(ride.getRoute().getId() != route.getId()) {
					
					routes.add(ride.getRoute());
				}
				
				
			}

		}
		
		return routes;
	}
	
	

}
