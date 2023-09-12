package com.cts.employeeTravelDesk.TravelPlanner.ServiceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employeeTravelDesk.TravelPlanner.Service.TravelRequestsService;
import com.cts.employeeTravelDesk.TravelPlanner.dao.TravelRequestsRepository;
import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;

import jakarta.transaction.Transactional;


@Service
public class TravelRequestsServiceImpl implements TravelRequestsService{
	@Autowired
	private TravelRequestsRepository travelRequestsRepository;
	
	@Override
	public List<String> insertTravelRequests(TravelRequests travelRequests) {
		List<String> validationMessages = new ArrayList<>();
		validationMessages.add(validateTravelRequest(travelRequests));
		if (validationMessages.get(0)=="") {
		travelRequestsRepository.save(travelRequests);
		return Collections.emptyList();
		}
		else {
			return validationMessages;
		}
		
	}
	
	private String validateTravelRequest(TravelRequests travelRequest) {
        // Validate the duration based on priority
        String priority = travelRequest.getPriority();
        int duration = calculateDays(travelRequest.getFromDate(), travelRequest.getToDate());

        if (priority.equalsIgnoreCase("Low") && duration > 30) {
            return ("Maximum allowed duration for Priority 1 is 30 days.");
        } else if (priority.equalsIgnoreCase("Medium") && duration > 20) {
        	return ("Maximum allowed duration for Priority 2 is 20 days.");
        } else if (priority.equalsIgnoreCase("High") && duration > 10) {
        	return ("Maximum allowed duration for Priority 3 is 10 days.");
        }
        else if(!priority.equalsIgnoreCase("Low") && !priority.equalsIgnoreCase("Medium") && !priority.equalsIgnoreCase("High")){
        return "Enter tha valid priority";
        }
        return "";
        // Additional validations or business rules can be added here
    }
	public int calculateDays(LocalDate fromDate, LocalDate toDate) {
        // Convert LocalDate to Date
        Date fromDateConverted = java.sql.Date.valueOf(fromDate);
        Date toDateConverted = java.sql.Date.valueOf(toDate);

        // Create Calendar instances
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        // Set the dates
        calendar1.setTime(fromDateConverted);
        calendar2.setTime(toDateConverted);

        // Calculate the difference in milliseconds
        long differenceInMillis = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();

        // Convert milliseconds to days
        long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMillis);

        // Add 1 to include both the start and end dates in the count
        return (int) differenceInDays + 1;
    }
	
	@Override
	public List<TravelRequests> getPendingRequestsForHRId(int toBeApprovedByHRId){
		return travelRequestsRepository.findAllByToBeApprovedByHRIdAndRequestStatus(toBeApprovedByHRId, "New");
	}
	
	@Override
	public TravelRequests getRequestById(int requestId) {
		Optional<TravelRequests> optionalRequest = travelRequestsRepository.findById(requestId);
		return optionalRequest.orElse(null);
	}
	
	@Override
	@Transactional
	public void rejectRequest(int requestId) {
		travelRequestsRepository.rejectRequest(requestId);
	}
	
	@Override
	@Transactional
	public void approveRequest(int requestId,int hrId) {
	            travelRequestsRepository.approveRequest(requestId, hrId);
	}
}
