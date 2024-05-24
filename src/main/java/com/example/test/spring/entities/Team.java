package com.example.test.spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "teams_generator")
    @SequenceGenerator(name = "teams_generator", allocationSize = 1)
    private Integer id;

    @Column
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "team_lead")
    private Employee teamLead;
}
