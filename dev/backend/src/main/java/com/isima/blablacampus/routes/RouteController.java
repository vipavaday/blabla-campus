package com.isima.blablacampus.routes;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isima.blablacampus.routes.service.impl.RouteService;
import com.isima.blablacampus.security.services.impl.UserService;



@RestController
@RequestMapping("/user/routes")
public class RouteController {
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RouteService routeService;
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Route> retrieveUserRoutes(@RequestParam (name="username") String username) {
		
		List<Ride> rides = userService.loadUserByUsername(username).getSubmittedRides();	
		
		return routeService.loadUserRoutes(rides);
	}
}
