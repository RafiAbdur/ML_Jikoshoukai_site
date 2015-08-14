package com.monstarlab.domain.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.monstarlab.domain.form.SearchEmployeeForm;
import com.monstarlab.domain.model.Employee;

public interface EmployeeService {
	
	/**
	 * Retrieves an employee by its id.
	 * 
	 * @param employeeId
	 * @return the employee with the given id
	 */
	public Employee findOne(String employeeId);

	/**
	 * Returns all the records of employees.
	 * 
	 * @param pageable
	 * @return a collection of employees
	 */
	public Collection<Employee> findAll();

	/**
	 * Returns a {@link Page} of employees meeting the paging restriction
	 * provided in the {@code Pageable} object.
	 * 
	 * @param pageable
	 * @return a page of employees
	 */
	Page<Employee> findAll(Pageable pageable);

	/**
	 * Creates the given employee.
	 * 
	 * @param employee
	 * @return the created entity
	 */
	Employee create(Employee employee);

	/**
	 * Updates the given employee.
	 * 
	 * @param employee
	 * @return the updated entity
	 */
	Employee update(Employee employee);

	/**
	 * Deletes an employee against his id number.
	 * 
	 * @param employeeId
	 */
	void delete(String employeeId);

	public Page<Employee> search(SearchEmployeeForm searchEmployeeForm, Pageable pageable);
	
}
