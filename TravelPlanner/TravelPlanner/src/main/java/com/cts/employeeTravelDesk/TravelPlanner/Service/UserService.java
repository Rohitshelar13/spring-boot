package com.cts.employeeTravelDesk.TravelPlanner.Service;

import com.cts.employeeTravelDesk.TravelPlanner.entities.User;

public interface UserService {
	void registerNewUser(User user);
	User authenticateUser(int employeeId, String password);
	User getUserDetails(int employeeId);
}
