package com.example.test.spring.models.entities;

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
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "all_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "job_title")
    private String jobTitle;
}
