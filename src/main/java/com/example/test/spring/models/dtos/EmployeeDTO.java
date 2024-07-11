package com.example.test.spring.models.dtos;

import com.example.test.spring.models.entities.Department;
import com.example.test.spring.models.entities.Position;
import com.example.test.spring.models.entities.Qualification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Department department;
    private Qualification qualification;
    private Position position;
    private String experience;
    private String salary;
}
