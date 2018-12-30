package com.hrm.orm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.orm.dao.DepartmentRepository;
import com.hrm.orm.dao.EmployeeRepository;
import com.hrm.orm.exception.ResourceNotFoundException;
import com.hrm.orm.model.Employee;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
   

    @GetMapping("/departments/{departmentId}/employees")
    public Page<Employee> getAllEmployeesByDepartmentId(@PathVariable (value = "departmentId") String departmentId,
                                                Pageable pageable) {
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }

    @PostMapping("/departments/{departmentId}/employees")
    public Employee createEmployee(@PathVariable (value = "departmentId") String departmentId,
                                 @Valid @RequestBody Employee employee) {
        return departmentRepository.findById(departmentId).map(department -> {
            employee.setDepartment(department);
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new ResourceNotFoundException("DepartmentId " + departmentId + " not found"));
    }
    

}


//@RestController
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @GetMapping("/departments/{departmentId}/employees")
//    public Page<EmployeeDetail> getAllEmployeeByDepartmentId(@PathVariable (value = "departmentId") String departmentId,
//                                                Pageable pageable) {
//        return employeeRepository.findByDepartmentId(departmentId, pageable); 
//    }
//
//    @PostMapping("/departments/{departmentId}/employees")
//    public EmployeeDetail createEmployee(@PathVariable (value = "departmentId") String departmentId,
//                                 @Valid @RequestBody EmployeeDetail employee) {
//        return departmentRepository.findById(departmentId).map(department -> {
//            employee.setEmployeeDepartment(department);
//            return employeeRepository.save(employee);
//        }).orElseThrow(() -> new ResourceNotFoundException("DepartmentId " + departmentId + " not found"));
//    }
//    
//	
//    @PutMapping("/departments/{departmentId}/employees/{employeeId}")
//    public EmployeeDetail updateEmployee(@PathVariable (value = "departmentId") String departmentId,
//                                 @PathVariable (value = "employeeId") String employeeId,
//                                 @Valid @RequestBody EmployeeDetail employeeRequest) {
//        if(!departmentRepository.existsById(departmentId)) {
//            throw new ResourceNotFoundException("DepartmentId " + departmentId + " not found");
//        }
//
//        return employeeRepository.findById(employeeId).map(employee -> {
//            employee.setFirst_name(employeeRequest.getFirst_name());
//            employee.setLast_name(employeeRequest.getLast_name());
//            employee.setEmail(employeeRequest.getEmail());
//            employee.setPhone_number(employeeRequest.getPhone_number());
//            employee.setHire_date(employeeRequest.getHire_date());
//            employee.setSalary(employeeRequest.getSalary());
//            employee.setCommission_pct(employeeRequest.getCommission_pct());
//            employee.setManager_id(employeeRequest.getManager_id());
//            
//            return employeeRepository.save(employee);
//        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + "not found"));
//    }
//
//    @DeleteMapping("/departments/{departmentId}/employees/{employeeId}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable (value = "departmentId") String departmentId,
//                              @PathVariable (value = "employeeId") String employeeId) {
//        if(!departmentRepository.existsById(departmentId)) {
//            throw new ResourceNotFoundException("DepartmentId " + departmentId + " not found");
//        }
//
//        return employeeRepository.findById(employeeId).map(employee -> {
//             employeeRepository.delete(employee);
//             return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
//    }
//}
