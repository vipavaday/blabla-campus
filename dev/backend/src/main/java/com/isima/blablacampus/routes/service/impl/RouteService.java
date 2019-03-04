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
		
		//Récupérer les itinéraires
//		List<Route> routes = null;
//		
//		if(rides !=null && rides.size() > 0) {
//			
//			Iterator<Ride> itRide = rides.iterator();
//			
//			routes = new ArrayList<Route>();
//			
//			Ride ride = itRide.next();
//			
//			Route route = ride.getRoute();
//			
//			routes.add(route);
//			
//			while(itRide.hasNext()) {
//				
//				ride = itRide.next();
//				
//				Iterator<Route> itRoute = routes.iterator();
//				
//				route = itRoute.next();
//				
//				while(ride.getRoute().getId() != route.getId()  && itRoute.hasNext()) {
//					
//					route = itRoute.next();
//					
//				}
//				
//				if(ride.getRoute().getId() != route.getId()) {
//					
//					routes.add(ride.getRoute());
//				}
//				
//				
//			}
//
//		}
		
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
