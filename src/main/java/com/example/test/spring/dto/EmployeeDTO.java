package com.example.test.spring.dto;

import com.example.test.spring.entities.Department;
import com.example.test.spring.entities.Position;
import com.example.test.spring.entities.Qualification;
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
    private Department department;
    private Qualification qualification;
    private Position position;
    private String experience;
    private String salary;
}
