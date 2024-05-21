package com.example.test.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String skillLevel;
    private String role;
    private String experience;
    private String salary;
}
