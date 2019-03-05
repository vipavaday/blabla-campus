package com.isima.blablacampus.routes;





import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.isima.blablacampus.routes.service.impl.PlaceService;
import com.isima.blablacampus.routes.service.impl.RideService;
import com.isima.blablacampus.routes.service.impl.RouteService;
import com.isima.blablacampus.security.services.impl.UserService;



@RestController
@RequestMapping("/user/routes")
public class RouteController {
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private RideService rideService;
	
	@Autowired
	private PlaceService placeService;
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Route> retrieveUserRoutes(@RequestParam (name="username") String email) {
		
		
		return routeService.loadUserRoutes(email);
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public boolean saveUserRoute(@RequestBody @Valid Route route ) {
		
		boolean saved = true;
	
		routeService.saveRoute(route);
		
		return saved;
		
	}
	
	
	@RequestMapping(name="/{id}", method=RequestMethod.PUT)
	public void saveUserRoute(@RequestBody @Valid Route route, @PathVariable int id ) {
		
	}
}
