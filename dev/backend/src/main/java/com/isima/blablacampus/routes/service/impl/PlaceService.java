package com.isima.blablacampus.routes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isima.blablacampus.routes.Place;
import com.isima.blablacampus.routes.exceptions.PlaceAlreadyExistException;
import com.isima.blablacampus.routes.service.IPlaceService;
import com.isima.blablacampus.routes.service.PlaceRepository;

@Service
public class PlaceService implements IPlaceService{
	
	@Autowired
	private PlaceRepository placeRepository;
	
	
	private boolean existByName(String name) {
		
		return placeRepository.findByName(name).isPresent();
	}

	@Override
	public void savePlace(Place place) throws PlaceAlreadyExistException{
		
		
		if(!existByName(place.getName())) {
			
			placeRepository.save(place);
			
		}else {
			
			throw new PlaceAlreadyExistException("The place "+ place.getName()+" already exist");
			
		}
		
		
	}

}
