package com.fazlerabbikhan.employeerestapi.repository;

import com.fazlerabbikhan.employeerestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}