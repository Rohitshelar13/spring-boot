package com.cts.employeeTravelDesk.TravelPlanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeTravelDesk.TravelPlanner.Service.RoleService;
import com.cts.employeeTravelDesk.TravelPlanner.entities.Role;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/createNewRole")
	public ResponseEntity<String> createNewRole(@RequestBody Role role){
		roleService.createNewRole(role);
		return ResponseEntity.ok("User role added successfully");
	}
	
}
