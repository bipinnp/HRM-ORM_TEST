package com.hrm.orm.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrm.orm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Page<Employee> findByDepartmentId(String departmentId, Pageable pageable);
	
}