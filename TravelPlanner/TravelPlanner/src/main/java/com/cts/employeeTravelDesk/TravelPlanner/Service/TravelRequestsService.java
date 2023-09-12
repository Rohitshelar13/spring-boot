package com.cts.employeeTravelDesk.TravelPlanner.Service;

import java.util.List;

import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;


public interface TravelRequestsService {
	List<String> insertTravelRequests(TravelRequests travelRequests);
	List<TravelRequests> getPendingRequestsForHRId(int toBeApprovedByHRId);
	TravelRequests getRequestById(int requestId);
	void rejectRequest(int requestId);
	void approveRequest(int requestId,int hrId);
}
