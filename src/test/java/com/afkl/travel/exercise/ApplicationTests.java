package com.afkl.travel.exercise;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.afkl.travel.exercise.model.Location;
import com.afkl.travel.exercise.service.LocationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	static Integer KNOWN_LOCATION_ID = 4469;
	static String KNOWN_TYPE = "country";
	static String KNOWN_CODE = "PR";
		
	@Autowired
	LocationService locationService;
	
	@Test
	@Order(1)
	public void contextLoads() {}
	
	@Test
	@Order(2) 
	public void testGetLocations() {
		List<Location> locations = locationService.getLocations();
		System.out.println("\ntestGetLocations:\n" + locations);
		assertThat(locations, hasSize(2234));
	}
	
	@Test
	@Order(3) 
	public void testGetLocationById() {
		Location location = locationService.getLocationById(KNOWN_LOCATION_ID);
		System.out.println("\ntestGetLocationById:\n" + location);
		assertNotNull(location);
		assertEquals(KNOWN_LOCATION_ID, location.getId());
	}
	
	@Test
	@Order(3) 
	public void testGetLocationByTypeAndCode() {
		Location location = locationService.getLocationByTypeAndCode(KNOWN_TYPE, KNOWN_CODE);
		System.out.println("\ntestGetLocationByTypeAndCode:\n" + location);
	}
	
}
