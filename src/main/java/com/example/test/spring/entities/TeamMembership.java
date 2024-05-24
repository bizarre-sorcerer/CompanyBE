package com.example.test.spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="team_membership")
public class TeamMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "teams_membership_generator")
    @SequenceGenerator(name = "teams_membership_generator", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee")
    private Employee employee
            ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_membership")
    private Team teamMembership;
}
