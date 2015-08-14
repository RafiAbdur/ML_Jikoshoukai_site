package com.monstarlab.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monstarlab.domain.form.SearchEmployeeForm;
import com.monstarlab.domain.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	@Query(value = "SELECT e FROM Employee e WHERE e.name LIKE %:name% AND e.surName LIKE %:surname%")
	Page<Employee> search(@Param("name") String name, @Param("surname") String surname, Pageable pageable);
}
