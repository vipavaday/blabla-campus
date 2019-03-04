package com.isima.blablacampus.routes.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.isima.blablacampus.routes.Place;

public interface PlaceRepository extends CrudRepository<Place, Integer>{
	
	public Optional<Place> findByName(String name);

}
