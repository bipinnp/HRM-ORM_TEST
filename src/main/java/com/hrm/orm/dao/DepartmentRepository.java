package com.hrm.orm.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrm.orm.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

	Page<Department> findById(String departmentId, Pageable pageable);
		
}
