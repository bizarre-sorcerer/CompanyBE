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
@Table(name = "qualification")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employees_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "salary")
    private String salary;

}
