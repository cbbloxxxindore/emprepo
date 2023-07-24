package com.vanguard.employeeservice.externalservice;

import com.vanguard.employeeservice.models.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "department-service")
public interface DepartmentService {

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department);
}
