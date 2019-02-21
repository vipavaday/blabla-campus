package com.isima.blablacampus.routes.service;

import java.util.List;

import com.isima.blablacampus.routes.Ride;
import com.isima.blablacampus.routes.Route;



public interface IRouteService {
	
	public List<Route> loadUserRoutes(List<Ride> rides);

}
