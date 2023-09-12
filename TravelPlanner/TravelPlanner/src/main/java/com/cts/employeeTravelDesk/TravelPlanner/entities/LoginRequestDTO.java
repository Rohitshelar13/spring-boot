package com.cts.employeeTravelDesk.TravelPlanner.entities;

public class LoginRequestDTO {
	private int employeeId;
	private String password;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRequestDTO(int employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}
	public LoginRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
