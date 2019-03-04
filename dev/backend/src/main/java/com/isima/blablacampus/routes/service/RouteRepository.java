package com.isima.blablacampus.routes.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.isima.blablacampus.routes.Place;
import com.isima.blablacampus.routes.Route;


public interface RouteRepository extends CrudRepository<Route, Integer>{
	
	public List<Route> findAllByStartingPoint(Place startingPoint);
	
	
	@Query("select r "
			+ "from Route r "
			+ "join Place p1 on r.startingPoint.id = p1.id "
			+ "join Place p2 on r.endPoint.id = p2.id "
			+ "where r.startingPoint.name = :startingPlaceName AND r.endPoint.name = :endPlaceName")
	public Optional<Route> findExistingRoute(@Param("startingPlaceName")String startingPlaceName, 
											@Param("endPlaceName")String endPlaceName);
	

	@Query("select ro from Ride ri JOIN User u ON ri.driver.userId=u.userId JOIN Route ro ON  ro.id = ri.route.id"
			+ " WHERE u.email = :email")
	public List<Route> findUserRoutes(@Param("email") String email);
}
