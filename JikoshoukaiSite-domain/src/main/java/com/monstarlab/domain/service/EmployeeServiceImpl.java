package com.monstarlab.domain.service;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monstarlab.domain.model.Employee;
import com.monstarlab.domain.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	// Employee repository object
	@Inject
	EmployeeRepository employeeRepository;
	
	
	/**
	 * Retrieves an employee by its id.
	 * 
	 * @param employeeId
	 * @return the employee with the given id
	 */
	@Override
	@Transactional(readOnly = true)
	public Employee findOne(String employeeId){
		return employeeRepository.findOne(employeeId);
	}

	/**
	 * Returns all the records of employees.
	 * 
	 * @param pageable
	 * @return a collection of employees
	 */
	@Override
	@Transactional(readOnly = true)
	public Collection<Employee> findAll() {
		return employeeRepository.findAll();
	}

	/**
	 * Returns a {@link Page} of employees meeting the paging restriction provided in the {@code Pageable} object.
	 * 
	 * @param pageable
	 * @return a page of employees
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Employee> findAll(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	/**
	 * Creates the given employee.
	 * 
	 * @param employee
	 * @return the created entity
	 */
	@Override
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * Updates the given employee.
	 * 
	 * @param employee
	 * @return the updated entity
	 */
	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * Deletes an employee against his id number.
	 * 
	 * @param employeeId
	 */
	@Override
	public void delete(String employeeId) {
		employeeRepository.delete(employeeId);
	}

}
