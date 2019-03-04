package com.isima.blablacampus.routes.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isima.blablacampus.routes.Ride;

public interface RideRepository extends CrudRepository<Ride, Integer>{

	public List<Ride> findAllByDate(Date date);
}
