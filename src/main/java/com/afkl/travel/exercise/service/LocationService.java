package com.afkl.travel.exercise.service;

import java.util.List;
import java.util.Optional;

import com.afkl.travel.exercise.model.Location;

public interface LocationService {

	Optional<Location> getLocationById(Integer id);
	
	List<Location> getLocations(); // GET all Locations
	
	Location getLocationByTypeAndCode(String type, String code);
}
