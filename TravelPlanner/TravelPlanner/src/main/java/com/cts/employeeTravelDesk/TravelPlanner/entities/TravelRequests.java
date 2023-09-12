package com.cts.employeeTravelDesk.TravelPlanner.entities;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TravelRequests {
	@Id
	@Column(length = 10)
	private int requestId;
	
	@Column(length = 10)
	private int raisedByEmployeeId;
	
	@Column(length = 10)
	private int toBeApprovedByHRId;
	
	private LocalDate requestRaisedOn;
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@Column(length = 100)
	private String purposeOfTravel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="locationId",referencedColumnName = "id")
	private Locations locations;
	
	@Column(length = 15)
	@Pattern(regexp="^(New|Approved|Rejected)$")
	private String requestStatus;
	private LocalDate requestApprovedOn;
	
	@Column(length = 6)
	private String priority;
	
	@OneToOne(mappedBy = "travelRequests")
	TravelBudgetAllocations travelBudgetAllocations;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getRaisedByEmployeeId() {
		return raisedByEmployeeId;
	}
	public void setRaisedByEmployeeId(int raisedByEmployeeId) {
		this.raisedByEmployeeId = raisedByEmployeeId;
	}
	public int getToBeApprovedByHRId() {
		return toBeApprovedByHRId;
	}
	public void setToBeApprovedByHRId(int toBeApprovedByHRId) {
		this.toBeApprovedByHRId = toBeApprovedByHRId;
	}
	public LocalDate getRequestRaisedOn() {
		return requestRaisedOn;
	}
	public void setRequestRaisedOn(LocalDate requestRaisedOn) {
		this.requestRaisedOn = requestRaisedOn;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getPurposeOfTravel() {
		return purposeOfTravel;
	}
	public void setPurposeOfTravel(String purposeOfTravel) {
		this.purposeOfTravel = purposeOfTravel;
	}
	public Locations getLocations() {
		return locations;
	}
	public void setLocations(Locations locations) {
		this.locations = locations;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public LocalDate getRequestApprovedOn() {
		return requestApprovedOn;
	}
	public void setRequestApprovedOn(LocalDate requestApprovedOn) {
		this.requestApprovedOn = requestApprovedOn;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public TravelRequests(int requestId, int raisedByEmployeeId, int toBeApprovedByHRId, LocalDate requestRaisedOn,
			LocalDate fromDate, LocalDate toDate, String purposeOfTravel, Locations locations, String requestStatus,
			LocalDate requestApprovedOn, String priority) {
		super();
		this.requestId = requestId;
		this.raisedByEmployeeId = raisedByEmployeeId;
		this.toBeApprovedByHRId = toBeApprovedByHRId;
		this.requestRaisedOn = requestRaisedOn;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.purposeOfTravel = purposeOfTravel;
		this.locations = locations;
		this.requestStatus = requestStatus;
		this.requestApprovedOn = requestApprovedOn;
		this.priority = priority;
	}
	public TravelRequests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}


//{
//  "raisedByEmployeeId": 10,
//  "toBeApprovedByHRId": 4,
//  "requestRaisedOn": "2023-05-03",
//  "fromDate": "2023-05-15",
//  "toDate": "2023-05-17",
//  "purposeOfTravel": "Meeting",
//  "requestStatus": "New",
//  "priority": "2"
//}






