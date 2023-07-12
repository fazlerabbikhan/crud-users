package com.fazlerabbikhan.employeerestapi.controller;

import com.fazlerabbikhan.employeerestapi.exception.ResourceNotFoundException;
import com.fazlerabbikhan.employeerestapi.model.Employee;
import com.fazlerabbikhan.employeerestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Create an employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //Get an employee by ID
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with ID" + id));
        return ResponseEntity.ok(employee);
    }

    //Update an employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updatedEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with ID" + id));

        updatedEmployee.setName(employeeDetails.getName());
        updatedEmployee.setUsername(employeeDetails.getUsername());
        updatedEmployee.setEmail(employeeDetails.getEmail());
        updatedEmployee.setPhone(employeeDetails.getPhone());
        updatedEmployee.setAddress(employeeDetails.getAddress());

        employeeRepository.save(updatedEmployee);

        return ResponseEntity.ok(updatedEmployee);
    }

    //Delete an employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with ID" + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
