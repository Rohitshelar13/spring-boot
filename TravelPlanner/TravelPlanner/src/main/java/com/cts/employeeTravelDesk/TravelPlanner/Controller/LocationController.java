package com.cts.employeeTravelDesk.TravelPlanner.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeTravelDesk.TravelPlanner.Service.LocationService;
import com.cts.employeeTravelDesk.TravelPlanner.entities.Locations;

@Component
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/locations")
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/getloc")
	public List<Locations> getAllLocations() {
        return locationService.getAllLocations();
    }
}
