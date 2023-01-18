package com.okta.developer.ADP_Capstone.Employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.Employee.exception.ResourceNotFoundException;
import com.okta.developer.ADP_Capstone.Employee.repository.EmployeeRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        

        updateEmployee.setRole(employeeDetails.getRole());
        updateEmployee.setlName(employeeDetails.getlName());
        updateEmployee.setfName(employeeDetails.getfName());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setPhone(employeeDetails.getPhone());
        updateEmployee.setAddress(employeeDetails.Address());
        updateEmployee.setZipCode(employeeDetails.getZipCode());
        updateEmployee.setCountry(employeeDetails.getCountry());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}













































/*import java.util.ArrayList;
import java.util.List;
import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.Employee.repository.EmployeeRepository;@RestController
*/









































//import springboot.api.tutorial.model.Employee;
//import springboot.api.tutorial.repository.EmployeeRepository;
/*@RequestMapping("/employee")
public class EmployeeController { @Autowired
 EmployeeRepository employeeRepository; @GetMapping("/employees")
 public List<Employee> getAllEmployees() {
  final List<Employee> employeeList = new ArrayList<Employee>();
  Iterable<Employee> iterable = employeeRepository.findAll();
  iterable.forEach(employeeList::add);
  return employeeList;
 } @GetMapping("/employees/{id}")
 public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
  Optional<Employee> employee = employeeRepository.findById(id);return employee.isPresent() ? new ResponseEntity<Employee>(employee.get(), HttpStatus.OK)
    : new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
 } @PostMapping("/employees")
 public Employee createProduct(@RequestBody Employee employee) {
  return employeeRepository.save(employee);
 } @PutMapping("/employees/{id}")
 public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee newEmployee) {
  Optional<Employee> employee = employeeRepository.findById(id); if (employee.isPresent()) {
   Employee prod = employee.get();
   prod.setRole(newEmployee.getRole());
   prod.setlName(newEmployee.getlName());
   prod.setfName(newEmployee.getfName());   
   prod.setEmail(newEmployee.getEmail());
   prod.setPhone(newEmployee.getPhone());
   prod.setAddress(newEmployee.getAddress());  
   prod.setZipCode(newEmployee.getZipCode());
   prod.setCountry(newEmployee.getCountry());  prod = employeeRepository.save(prod);   
   return ResponseEntity.ok().body(prod);
  } else {
   return ResponseEntity.notFound().build();
  }*/
	/*
	 * } @DeleteMapping("/products/{id}") public ResponseEntity<Product>
	 * deleteProduct(@PathVariable(value = "id") Long id) { Optional<Product>
	 * product = productRepository.findById(id); if (product.isPresent()) {
	 * productRepository.delete(product.get()); return new
	 * ResponseEntity("Product has been deleted successfully.", HttpStatus.OK); }
	 * else { return ResponseEntity.notFound().build(); }
	 */


