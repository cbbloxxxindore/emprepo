package com.vanguard.employeeservice.service;

import com.vanguard.employeeservice.externalservice.DepartmentService;
import com.vanguard.employeeservice.models.Department;
import com.vanguard.employeeservice.models.Employee;
import com.vanguard.employeeservice.models.EmployeeDetail;
import com.vanguard.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements  EmployeeService {
    @Autowired
private DepartmentService departmentService;
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(EmployeeDetail employeeDetail) {

        Employee employee = employeeDetail.getEmployee();
        Department department = employeeDetail.getDepartment();
        ResponseEntity<Department> department1 = departmentService.createDepartment(department);
        Department department2 = department1.getBody();
employee.setDid(department2.getDid());
        return employeeRepository.save(employee);
    }
}
