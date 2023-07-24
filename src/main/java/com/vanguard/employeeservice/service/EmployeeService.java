package com.vanguard.employeeservice.service;

import com.vanguard.employeeservice.models.Employee;
import com.vanguard.employeeservice.models.EmployeeDetail;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDetail employeeDetail);
}
