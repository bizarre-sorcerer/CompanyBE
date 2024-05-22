package com.example.test.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer departmentId;
    private String skillLevel;
    private String role;
    private String experience;
    private String salary;
}
