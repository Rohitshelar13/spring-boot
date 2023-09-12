package com.cts.employeeTravelDesk.TravelPlanner.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelRequests;

@Repository
public interface TravelRequestsRepository extends JpaRepository<TravelRequests, Integer>{
	List<TravelRequests> findAllByToBeApprovedByHRIdAndRequestStatus(int toBeApprovedByHRId, String requestStatus);
	Optional<TravelRequests> findById(int requestId);
	
	@Modifying
	@Query("UPDATE TravelRequests SET requestStatus = 'Rejected' WHERE requestId = :requestId and requestStatus = 'New'")
	void rejectRequest(@Param("requestId") int requestId);
	
	@Modifying
	@Query("UPDATE TravelRequests SET requestStatus='Approved', requestApprovedOn=CURRENT_DATE, toBeApprovedByHRId= :hrId WHERE requestId = :requestId and requestStatus = 'New' and toBeApprovedByHRId = :hrId")
	void approveRequest(@Param("requestId") int requestId, @Param("hrId") int hrId);
}
