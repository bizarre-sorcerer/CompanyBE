package com.example.test.spring.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String projectName;
    private String startDate;
    private String deadlineDate;
}
