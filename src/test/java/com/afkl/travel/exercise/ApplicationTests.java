package com.afkl.travel.exercise;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.afkl.travel.exercise.controller.IndexController;
import com.afkl.travel.exercise.controller.LocationsController;
import com.afkl.travel.exercise.model.Location;
import com.afkl.travel.exercise.service.LocationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	static Integer KNOWN_LOCATION_ID = 4469;
	static String KNOWN_TYPE = "country";
	static String KNOWN_CODE = "PR";
		
    private MockMvc mockMvcForIndex;
    private MockMvc mockMvcForLocations;
    
	@Autowired
	private LocationService locationService;
	
    @Before
    public void setup() {
        this.mockMvcForIndex = MockMvcBuilders.standaloneSetup(new IndexController()).build();
        this.mockMvcForLocations = MockMvcBuilders.standaloneSetup(new LocationsController()).build();
    }
	
	@Test
	@Order(1)
	public void contextLoads() {}
	
	/**
	 * Test Controllers
	 */
    @Test
    @Order(2)
    public void testIndexController() throws Exception {
        this.mockMvcForIndex.perform(get("/travel")).andExpect(status().isOk());
    }

    //@Test
    @Order(3)
    public void testLocationsController() throws Exception {
        this.mockMvcForLocations.perform(get("/travel/locations")).andExpect(status().isOk());
    }
	
	/**
	 * Test Service and Repos
	 */
	@Test
	@Order(4) 
	public void testGetLocations() {
		List<Location> locations = locationService.getLocations();
		System.out.println("\ntestGetLocations:\n" + locations);
		assertThat(locations, hasSize(2234));
	}
	
	@Test
	@Order(5) 
	public void testGetLocationById() {
		Location location = locationService.getLocationById(KNOWN_LOCATION_ID);
		System.out.println("\ntestGetLocationById:\n" + location);
		assertNotNull(location);
		assertEquals(KNOWN_LOCATION_ID, location.getId());
	}
	
	@Test
	@Order(6) 
	public void testGetLocationByTypeAndCode() {
		Location location = locationService.getLocationByTypeAndCode(KNOWN_TYPE, KNOWN_CODE);
		System.out.println("\ntestGetLocationByTypeAndCode:\n" + location);
		assertNotNull(location);
		assertEquals(KNOWN_LOCATION_ID, location.getId());
	}
	
}
