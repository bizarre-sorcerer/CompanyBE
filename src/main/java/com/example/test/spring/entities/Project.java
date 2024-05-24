package com.example.test.spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "projects_generator")
    @SequenceGenerator(name = "projects_generator", allocationSize = 1)
    private Integer id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "deadline_date")
    private String deadlineDate;

    @Column(name = "responsible_team")
    private String responsibleTeam;

    @Column(name = "budget")
    private String budget;
}
