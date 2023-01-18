package com.okta.developer.ADP_Capstone.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;

/* EmployeeRepository.java
 * This repository "talks" with the database for the Employee entity
 * */

public interface EmployeeRepository extends JpaRepository <Employee, Long> { 
	
	
}

