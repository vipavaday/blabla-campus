package com.isima.blablacampus.routes.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	public List<Route> loadUserRoutes(String email) {
		
		List<Route> routes = routeRepository.findUserRoutes(email);
		
		return routes;
	}




	@Override
	public void saveRoute(Route route) {
				
		Optional<Route> dbRoute = routeRepository.findExistingRoute(route.getStartingPoint().getName(), route.getEndPoint().getName());
		
		if( dbRoute.isPresent() && dbRoute != null) {
			
			dbRoute.get().setRides(route.getRides());
			
			dbRoute.get().getRides().stream().forEach((ride)->ride.setRoute(dbRoute.get()));
			
			routeRepository.save(dbRoute.get());
			
		}else {
			
			route.getRides().stream().forEach((ride)->ride.setRoute(route));
			
			routeRepository.save(route);
			
		}
	
		
	}
	
	

}
