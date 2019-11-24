package com.afkl.travel.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.travel.exercise.model.Location;
import com.afkl.travel.exercise.service.LocationService;

@RestController
@RequestMapping("/travel/locations")
public class LocationsController {
	
	@Autowired
	LocationService locationService;

    @GetMapping()
    List<Location> locations() {
    	return locationService.getLocations();
    }
    
    @GetMapping("/{type}/{code}") // i.e. /travel/locations/country/PR
    Location locationByTypeAndCode(@PathVariable String type, @PathVariable String code) {
    	return locationService.getLocationByTypeAndCode(type, code);
    }
       
}
