package com.okta.developer.ADP_Capstone.Employee.service;

import java.util.List;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
/*EmployeeService.java
 * Contains abstract methods which is implemented in EmployeeServiceImpl package
 *
 * */
public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(long id, Employee employee);
    void deleteEmployeeById( long id);

}
