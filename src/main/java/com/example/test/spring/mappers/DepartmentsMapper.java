package com.example.test.spring.mappers;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.entities.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentsMapper {
    Department toEntity(DepartmentDTO departmentDTO);

    DepartmentDTO toDTO(Department department);
}
