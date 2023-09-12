package com.cts.employeeTravelDesk.TravelPlanner.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Role {
	
	@Id
	@Column(length = 10)
	private String roleName;
	@Column(length = 10)
	private String roleDescription;
	
	@OneToMany(mappedBy = "role")
	List<User> user = new ArrayList<>();
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Role(String roleName, String roleDescription, List<User> user) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.user = user;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}


//{
//    "firstName": "Rohit",
//    "lastName": "Shelar",
//    "grade": "Grade 1",
//    "phoneNumber": "7038199002",
//    "emailId": "rohit@gmail.com",
//    "password":"Rohit@1234",
//    "role": [
//    {
//      "roleName": "HR",
//      "roleDescription": "These user"
//    }
//  ]
//}

