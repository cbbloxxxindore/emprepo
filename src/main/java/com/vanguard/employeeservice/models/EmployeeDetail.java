package com.vanguard.employeeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class EmployeeDetail {
    private Employee employee;
    private  Department department;
}
