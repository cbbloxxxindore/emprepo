package com.vanguard.employeeservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int did;
    private  String departmentName;

}
