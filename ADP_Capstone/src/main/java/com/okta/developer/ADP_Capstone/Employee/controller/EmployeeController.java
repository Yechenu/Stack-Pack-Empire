package com.okta.developer.ADP_Capstone.Employee.controller;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.Employee.Service.EmployeeService;

/*EmployeeController.java contains the 4 endpoints/URL/CRUD operations
 * (Get, Post, Put, and Delete Mapping)
 * @Aladi
 * */

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * Get all the employees
	 *
	 * @return ResponseEntity
	 */
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		try {
			return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Get the employee by id
	 *
	 * @param id
	 * @return ResponseEntity
	 */
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);

	}

	/**
	 * Create new employee
	 *
	 * @param employee
	 * @return ResponseEntity
	 */
	@PostMapping("/employee")
	public ResponseEntity<Employee> newEmployee(@Validated @RequestBody Employee employee) {
		Employee newEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	/**
	 * Update Employee record by using employee id
	 *
	 * @param id
	 * @param employee
	 * @return
	 */
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Employee updEmp = employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>(updEmp, HttpStatus.OK);
	}

	/**
	 * Delete Employee by Id
	 *
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") long id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}











































