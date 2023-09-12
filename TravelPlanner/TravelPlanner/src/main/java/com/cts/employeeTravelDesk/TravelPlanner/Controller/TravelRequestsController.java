package com.cts.employeeTravelDesk.TravelPlanner.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeTravelDesk.TravelPlanner.Service.TravelRequestsService;
import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/travelRequests")
public class TravelRequestsController {
	@Autowired
	private TravelRequestsService travelRequestsService;
	public class ApiResponse {
		private String message;

		public ApiResponse(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	@PostMapping("/addTravel")
	public ResponseEntity<Object> insertTravelRequests(@RequestBody TravelRequests travelRequests) {
		List<String> validationMessages = travelRequestsService.insertTravelRequests(travelRequests);
	    if (validationMessages.isEmpty()) {
//	        TravelRequests createdRequest = travelRequestsService.insertTravelRequestsAndGetId(travelRequests);
	        return ResponseEntity.ok(travelRequests.getRequestId());
	    } else {
	        StringBuilder sb = new StringBuilder();
	        for (String message : validationMessages) {
	            sb.append(message).append("\n");
	        }
	        return ResponseEntity.badRequest().body(sb.toString());
	    }
	}
	
	@GetMapping("/pending-requests/{toBeApprovedByHRId}")
	public ResponseEntity<List<TravelRequests>> getPendingRequestsForHRId(@PathVariable Integer toBeApprovedByHRId){
		List<TravelRequests> pendingRequests = travelRequestsService.getPendingRequestsForHRId(toBeApprovedByHRId);
		return ResponseEntity.ok(pendingRequests);
	}
	
	@GetMapping("/{requestId}")
	public ResponseEntity<TravelRequests> getRequestById(@PathVariable("requestId") int requestId){
		TravelRequests request = travelRequestsService.getRequestById(requestId);
		if(request==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(request);
	}
	
	@PutMapping("/{requestId}/reject")
	public ResponseEntity<Object> rejectRequest(@PathVariable("requestId") int requestId){
		travelRequestsService.rejectRequest(requestId);
		return ResponseEntity.ok(requestId);
	}
	@PutMapping("/{requestId}/approve")
	public ResponseEntity<Object> approveRequest(@PathVariable("requestId") int requestId, @RequestParam("hrId") int hrId){
		travelRequestsService.approveRequest(requestId, hrId);
		return ResponseEntity.ok(requestId);
	}
}
