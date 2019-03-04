package com.isima.blablacampus.routes.service;

import com.isima.blablacampus.routes.Place;
import com.isima.blablacampus.routes.exceptions.PlaceAlreadyExistException;

public interface IPlaceService {
	
	public void savePlace(Place place) throws PlaceAlreadyExistException;

}
