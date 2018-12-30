package com.hrm.orm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.orm.dao.DepartmentRepository;
import com.hrm.orm.exception.ResourceNotFoundException;
import com.hrm.orm.model.Department;


@RestController
public class DepartmentController {
	
	@Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
    
    @GetMapping("/departments/{departmentId}")
    public Page<Department> getDepartments(@PathVariable String departmentId,Pageable pageable) {
        return departmentRepository.findById(departmentId,pageable);
    }

    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId, @Valid @RequestBody Department departmentRequest) {
        return departmentRepository.findById(departmentId).map(department -> {
            department.setDepartment_name(departmentRequest.getDepartment_name());
            department.setManager_id(departmentRequest.getManager_id());
            return departmentRepository.save(department);
        }).orElseThrow(() -> new ResourceNotFoundException("DepartmentId " + departmentId + " not found"));
    }


/*    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String departmentId) {
        return departmentRepository.findById(departmentId).map(department -> {
        	   departmentRepository.delete(department);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("DepartmentId " + departmentId + " not found"));
    }*/

}
