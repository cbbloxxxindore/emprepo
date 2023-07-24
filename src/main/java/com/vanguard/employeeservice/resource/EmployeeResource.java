package com.vanguard.employeeservice.resource;

import com.vanguard.employeeservice.models.Employee;
import com.vanguard.employeeservice.models.EmployeeDetail;
import com.vanguard.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeResource {
    private  EmployeeService employeeService;
private final String EMPLOYEE_SERVICE="employeeService";
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/employees")
    @CircuitBreaker(name = EMPLOYEE_SERVICE,fallbackMethod = "getFallback")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDetail employeeDetail)
    {
        Employee employee1 = employeeService.saveEmployee(employeeDetail);
        return  ResponseEntity.ok(employee1);

    }
    public  ResponseEntity<Employee> getFallback(Throwable throwable)
    {
        Employee employee= new Employee();employee.setId(1);
        employee.setName("john");
        ResponseEntity<Employee> responseEntity=ResponseEntity.ok(employee);
      return  responseEntity;
    }
}
