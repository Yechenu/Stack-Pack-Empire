package com.okta.developer.ADP_Capstone.Employee.Impl;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.okta.developer.ADP_Capstone.Employee.exception.GeneralException;
	import com.okta.developer.ADP_Capstone.Employee.exception.RecordNotFoundException;
	import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
	import com.okta.developer.ADP_Capstone.Employee.entity.Location;
	import com.okta.developer.ADP_Capstone.Employee.repository.EmployeeRepository;
	import com.okta.developer.ADP_Capstone.Employee.Service.EmployeeService;

	/*
	 * Employee.ServiceImpl.java
	 * contains methods that's called from the controller
	 * 
	 * 
	 */
	
	@Service
	public class EmployeeServiceImpl implements EmployeeService {

		@Autowired
		EmployeeRepository employeeRepository;

		/**
		 * Get the list of all employees
		 *
		 * //@param id
		 * @return Employee
		 */
		@Override
		public List<Employee> getAllEmployees() {
			try {
				return employeeRepository.findAll();
			} catch (Exception e) {
				throw new GeneralException(e.getMessage());
			}
		}

		/**
		 * Get the employee by id
		 *
		 * @param id
		 * @return Employee
		 */
		@Override
		public Employee getEmployeeById(long id) {
			try {
				// check if employee exist in database
				Employee empObj = getEmployeeRecord(id);

				if (empObj != null) {
					return empObj;
				} else {
					throw new RecordNotFoundException("Resource with id:" + id + " not found");
				}
			} catch (Exception e) {
				throw new GeneralException(e.getMessage());
			}

		}

		/**
		 * Create new employee
		 *
		 * @param employee
		 * @return ResponseEntity
		 */
		@Override
		public Employee createEmployee(Employee employee) {
			try {
				Employee newEmployee = employeeRepository.save(employee);
				return newEmployee;
			} catch (Exception e) {
				throw new GeneralException(e.getMessage());
			}
		}

		/**
		 * Update Employee record by using it's id
		 *
		 * @param id
		 * @param employee
		 * @return
		 */
		@Override
		public Employee updateEmployee(long id, Employee employee) {

			// check if employee exist in database
			Employee empObj = getEmployeeRecord(id);

			if (empObj != null) {
				// update only those records received from client.
				// check if field is not null in emp request.
				empObj.setJob_title(employee.getJob_title() != null ? employee.getJob_title() : empObj.getJob_title());
				empObj.setFirstName(employee.getFirstName() != null ? employee.getFirstName() : empObj.getFirstName());
				empObj.setLastName(employee.getLastName() != null ? employee.getLastName() : empObj.getLastName());
				empObj.setPhone(employee.getPhone() != null ? employee.getPhone() : empObj.getPhone());
				empObj.setEmail(employee.getEmail() != null ? employee.getEmail() : empObj.getEmail());


				Location dbLocation = empObj.getLocation();
				
				//getting location from request. If request location is present then only update the fields, otherwise ignore.
				Location location = employee.getLocation();
				if (location != null) {
					dbLocation.setBldgnum(location.getBldgnum() != null ? location.getBldgnum() : dbLocation.getBldgnum());
					dbLocation.setAddress(location.getAddress() != null ? location.getAddress() : dbLocation.getAddress());
					dbLocation.setCity(location.getCity() != null ? location.getCity() : dbLocation.getCity());
					dbLocation.setState(location.getState() != null ? location.getState() : dbLocation.getState());
					dbLocation.setCountry(location.getCountry() != null ? location.getCountry() : dbLocation.getCountry());

				}

				empObj.setLocation(dbLocation);

				return employeeRepository.save(empObj);
			} else {
				throw new RecordNotFoundException("Resource with id:" + id + " not found");
			}

		}

		/**
		 * Delete Employee by Id
		 *
		 * @param id
		 * @return void
		 */
		@Override
		public void deleteEmployeeById(long id) {
			try {
				// check if employee exist in database
				Employee emp = getEmployeeRecord(id);

				if (emp != null) {
					employeeRepository.deleteById(id);
				} else {
					throw new RecordNotFoundException("Resource with id:" + id + " not found");
				}

			} catch (Exception e) {
				throw new GeneralException(e.getMessage());
			}
		}

		/**
		 * Method to get the employee record by id
		 *
		 * @param id
		 * @return Employee
		 */
		private Employee getEmployeeRecord(long id) {
			Optional<Employee> empObj = employeeRepository.findById(id);

			if (empObj.isPresent()) {
				return empObj.get();
			}
			return null;
		}

	}

