package com.monstarlab.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.monstarlab.domain.model.Employee;

public interface EmployeeService {
	// Find all employees and get according to page display limitation
	Page<Employee> findAll(Pageable pageable);

	// Create new employee
	Employee create(Employee employee);

	// Update current employee information
	Employee update(Employee employee);

	// Delete current employee
	void delete(int employeeId);
}
