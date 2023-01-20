package com.okta.developer.ADP_Capstone.Employee.repository;

import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *EmployeeRepository.java
 * This repository "talks" with the database for the Employee entity
 * - Retrieves the Employee Entity by its email.
 *
 * @Diamond Brown
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    //Query for employee by email. Returns boolean
    Boolean existsByEmail(String email); //Checks if there are any records in db by email

    //**DEMO ONLY**
    //Boolean existsBy(); Checks if there are any records in the employee db
}