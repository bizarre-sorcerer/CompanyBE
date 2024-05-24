package com.example.test.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employees_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qualification")
    private Qualification qualification;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position")
    private Position position;

    @Column(name = "experience")
    private String experience;

    @Column(name = "salary")
    private String salary;
}