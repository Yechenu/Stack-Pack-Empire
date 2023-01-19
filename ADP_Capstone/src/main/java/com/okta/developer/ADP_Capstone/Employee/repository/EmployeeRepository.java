package com.okta.developer.ADP_Capstone.Employee.repository;

import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *EmployeeRepository.java
 * This repository "talks" with the database for the role entity
 * - Retrieves the Employee Entity by its email.
 *
 * @Diamond Brown
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Query for employee by email. Returns Employee obj
     Employee findByEmail(String email);
}