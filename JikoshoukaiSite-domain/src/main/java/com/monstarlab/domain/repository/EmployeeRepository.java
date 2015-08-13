package com.monstarlab.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monstarlab.domain.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, String>{

}
