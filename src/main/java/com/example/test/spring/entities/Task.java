package com.example.test.spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tasks_generator")
    @SequenceGenerator(name = "tasks_generator", allocationSize = 1)
    private Integer id;

    @Column
    private String taskName;

    @ManyToOne
    @JoinColumn(name = "part_of_project")
    private Project project;
}
