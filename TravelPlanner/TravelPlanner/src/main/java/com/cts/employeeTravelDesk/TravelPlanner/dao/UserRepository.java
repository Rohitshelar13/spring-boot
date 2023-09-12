package com.cts.employeeTravelDesk.TravelPlanner.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.employeeTravelDesk.TravelPlanner.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmployeeIdAndPassword(int employeeId,String password);
	Optional<User> findById(int employeeId);
}
