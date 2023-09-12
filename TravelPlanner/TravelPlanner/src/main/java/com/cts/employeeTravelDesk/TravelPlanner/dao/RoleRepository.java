package com.cts.employeeTravelDesk.TravelPlanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.employeeTravelDesk.TravelPlanner.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
