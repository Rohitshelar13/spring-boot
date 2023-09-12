package com.cts.employeeTravelDesk.TravelPlanner.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class TravelBudgetAllocations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private int id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="travelRequestId",referencedColumnName = "requestId")
	private TravelRequests travelRequests;
	
	@Column(length = 10)
	private int approvedBudget;
	
	@Pattern(regexp="^(Air|Train|Bus)$")
	@Column(length = 10)
	private String approvedModeOfTravel;
	
	@Pattern(regexp="^(3-Star|5-Star|7-Star)$")
	@Column(length = 6)
	private String approvedHotelStarRating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TravelRequests getTravelRequests() {
		return travelRequests;
	}
	public void setTravelRequests(TravelRequests travelRequests) {
		this.travelRequests = travelRequests;
	}
	public int getApprovedBudget() {
		return approvedBudget;
	}
	public void setApprovedBudget(int approvedBudget) {
		this.approvedBudget = approvedBudget;
	}
	public String getApprovedModeOfTravel() {
		return approvedModeOfTravel;
	}
	public void setApprovedModeOfTravel(String approvedModeOfTravel) {
		this.approvedModeOfTravel = approvedModeOfTravel;
	}
	public String getApprovedHotelStarRating() {
		return approvedHotelStarRating;
	}
	public void setApprovedHotelStarRating(String approvedHotelStarRating) {
		this.approvedHotelStarRating = approvedHotelStarRating;
	}
	public TravelBudgetAllocations(int id, TravelRequests travelRequests, int approvedBudget,
			String approvedModeOfTravel, String approvedHotelStarRating) {
		super();
		this.id = id;
		this.travelRequests = travelRequests;
		this.approvedBudget = approvedBudget;
		this.approvedModeOfTravel = approvedModeOfTravel;
		this.approvedHotelStarRating = approvedHotelStarRating;
	}
	
	
}
