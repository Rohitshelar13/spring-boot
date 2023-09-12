package com.cts.employeeTravelDesk.TravelPlanner.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employeeTravelDesk.TravelPlanner.Service.LocationService;
import com.cts.employeeTravelDesk.TravelPlanner.dao.LocationsRepository;
import com.cts.employeeTravelDesk.TravelPlanner.entities.Locations;

@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	public LocationsRepository locationsRepository;
	
	@Override
	public List<Locations> getAllLocations() {
        return locationsRepository.findAll();
    }
}
