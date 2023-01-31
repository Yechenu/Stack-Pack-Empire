package com.okta.developer.ADP_Capstone.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import org.springframework.data.jpa.repository.Query;

/* EmployeeRepository.java
 * This repository "talks" with the database for the Employee entity
 * */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select count(e) from Employee e where e.employeeID = ?1")
    long countByEmployeeID(Long employeeID);

}