package com.isima.blablacampus.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isima.blablacampus.security.model.User;

@RestController
@RequestMapping("/user/routes")
public class RouteController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String retrieveUserRoutes(User u) {
		
		return "routes";
	}
}
