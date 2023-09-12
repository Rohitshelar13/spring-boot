package com.cts.employeeTravelDesk.TravelPlanner.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employeeTravelDesk.TravelPlanner.Service.RoleService;
import com.cts.employeeTravelDesk.TravelPlanner.dao.RoleRepository;
import com.cts.employeeTravelDesk.TravelPlanner.entities.Role;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	public RoleRepository roleRepository;
	
	@Override
	public void createNewRole (Role role) {
		roleRepository.save(role);
	}
}
