package com.afkl.travel.exercise.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afkl.travel.exercise.model.Location;
import com.afkl.travel.exercise.repository.LocationRepo;
import com.afkl.travel.exercise.repository.LocationRepoByTypeAndCode;
import com.afkl.travel.exercise.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationRepo locationRepo;

	@Autowired
	LocationRepoByTypeAndCode locationRepoByTypeAndCode;
	
	@Override
	public List<Location> getLocations() {
		return locationRepo.findAll();
	}

	@Override	
	public Optional<Location> getLocationById(Integer id) {
		return locationRepo.findById(id);
	}

	@Override
	public Location getLocationByTypeAndCode(String type, String code) {
		return locationRepoByTypeAndCode.getLocationByTypeAndCode(type, code);
	}
}
