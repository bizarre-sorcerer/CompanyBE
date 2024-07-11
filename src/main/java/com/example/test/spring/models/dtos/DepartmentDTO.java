package com.example.test.spring.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartmentDTO{
    private String departmentId;
    private String departmentName;

}
