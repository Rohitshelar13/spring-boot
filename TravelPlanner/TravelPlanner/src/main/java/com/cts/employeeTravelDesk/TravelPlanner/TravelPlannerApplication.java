package com.cts.employeeTravelDesk.TravelPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.cts.employeeTravelDesk.TravelPlanner.Service.TravelRequestsService;
//import com.cts.employeeTravelDesk.TravelPlanner.ServiceImpl.TravelRequestsServiceImpl;
//import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;

@SpringBootApplication
public class TravelPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
//		ConfigurableApplicationContext context =  SpringApplication.run(TravelPlannerApplication.class, args);
//		TravelRequestsService travelRequestsService = context.getBean(TravelRequestsServiceImpl.class);
//		TravelRequests travelrequests1 = new TravelRequests();
//		travelrequests1.setToBeApprovedByHRId(9);
//		travelRequestsService.insertTravelRequests(travelrequests1);
	}

}
