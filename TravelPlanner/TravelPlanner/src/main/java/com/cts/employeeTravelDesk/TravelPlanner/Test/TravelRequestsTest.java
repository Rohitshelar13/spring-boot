package com.cts.employeeTravelDesk.TravelPlanner.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cts.employeeTravelDesk.TravelPlanner.Service.TravelRequestsService;
import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TravelRequestsTest {
	@Autowired
    private TravelRequestsService travelRequestsService;

    private TravelRequests travelRequests;

    @Before
    public void setup() {
        travelRequests = new TravelRequests();
        travelRequests.setRequestId(123);
        travelRequests.setRaisedByEmployeeId(90);
    }
    
    @Test
    public void testApproveRequest() {
       
    	// Perform the approve request operation
    	travelRequestsService.approveRequest(5, 9);

    	// Retrieve the updated travel request from the repository
    	TravelRequests travelRequests = travelRequestsService.getRequestById(5);

    	// Assert that the travel request is not null
//    	assertNotNull(travelRequests);

    	// Assert that the request status is set to "Approved"
    	assertEquals("Approved", travelRequests.getRequestStatus());
        
    }
}
