package com.cts.employeeTravelDesk.TravelPlanner.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.employeeTravelDesk.TravelPlanner.Service.UserService;
import com.cts.employeeTravelDesk.TravelPlanner.dao.UserRepository;
import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;
import com.cts.employeeTravelDesk.TravelPlanner.entities.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private User user;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Override
	public void registerNewUser(User user) {
//		user.setPassword(getEnocdedPassword(user.getPassword()));   
		userRepository.save(user);
	}
	
	@Override
	public User authenticateUser(int employeeId,String password) {
		return userRepository.findByEmployeeIdAndPassword(employeeId,password);
	}
	
	@Override
	public User getUserDetails(int employeeId) {
		Optional<User> optionalRequest = userRepository.findById(employeeId);
		return optionalRequest.orElse(null);
	}
//	public String getEnocdedPassword(String password) {
//		return passwordEncoder.encode(password);
//	}
}
