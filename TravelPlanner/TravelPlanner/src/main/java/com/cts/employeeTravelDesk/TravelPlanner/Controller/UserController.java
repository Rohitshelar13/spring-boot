package com.cts.employeeTravelDesk.TravelPlanner.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeTravelDesk.TravelPlanner.Service.UserService;
import com.cts.employeeTravelDesk.TravelPlanner.entities.LoginRequestDTO;
import com.cts.employeeTravelDesk.TravelPlanner.entities.User;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/registerNewUser")
	public ResponseEntity<String> registerNewUser(@RequestBody User user){
		userService.registerNewUser(user);
		return ResponseEntity.ok("User created successfully");
	}
	
	@PostMapping("/login")
	  public ResponseEntity<User> login(@RequestBody LoginRequestDTO loginRequest) {
		Integer employeeId = loginRequest.getEmployeeId();
        String password = loginRequest.getPassword();

        if (employeeId == null || password == null) {
            return null;
        }
	    User user = userService.authenticateUser(employeeId, password);

	    if (user == null) {
	      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }

	    return ResponseEntity.ok(user);
	  }
	
	@GetMapping("/users/{employeeId}")
	public ResponseEntity<User> getUserDetails(@PathVariable("employeeId") int employeeId){
		User request = userService.getUserDetails(employeeId);
		if(request==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(request);
	}
//	@GetMapping({"/forAdmin"})
//    @PreAuthorize("hasRole('HR')")
//    public String forAdmin(){
//        return "This URL is only accessible to the admin";
//    }
//
//    @GetMapping({"/forUser"})
//    @PreAuthorize("hasRole('HR')")
//    public String forUser(){
//        return "This URL is only accessible to the user";
//    }
}
