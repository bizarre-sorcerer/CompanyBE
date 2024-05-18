package com.example.TestSpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String skillLevel;
    private String role;
    private String experience;
    private String salary;
}
