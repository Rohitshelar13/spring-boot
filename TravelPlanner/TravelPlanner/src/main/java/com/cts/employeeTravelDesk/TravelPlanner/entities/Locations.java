package com.cts.employeeTravelDesk.TravelPlanner.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Locations {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 10)
	private int id;
	
	@Column(length = 20)
	private String name;
	
	@OneToMany(mappedBy = "locations")
	List<TravelRequests> travelRequests = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Locations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Locations(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
