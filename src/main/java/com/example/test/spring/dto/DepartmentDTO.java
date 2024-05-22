package com.example.test.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DepartmentDTO implements Serializable {
    private Integer id;
    private String departmentName;
}
