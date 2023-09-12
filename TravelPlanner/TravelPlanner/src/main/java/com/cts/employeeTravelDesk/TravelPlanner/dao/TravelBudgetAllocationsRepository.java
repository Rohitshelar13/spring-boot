package com.cts.employeeTravelDesk.TravelPlanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.employeeTravelDesk.TravelPlanner.entities.TravelBudgetAllocations;

@Repository
public interface TravelBudgetAllocationsRepository extends JpaRepository<TravelBudgetAllocations, Integer>{

}
