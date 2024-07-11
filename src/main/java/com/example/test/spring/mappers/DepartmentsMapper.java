package com.example.test.spring.mappers;

import com.example.test.spring.models.dtos.DepartmentDTO;
import com.example.test.spring.models.entities.Department;
import com.example.test.spring.utils.DepartmentsUtil;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = DepartmentsUtil.class)
public interface DepartmentsMapper {

    @Mapping(source = "departmentId", target = "id", qualifiedByName = "convertToLong")
    Department toEntity(DepartmentDTO departmentDTO);

    @Mapping(source = "id", target = "departmentId", qualifiedByName = "convertToString")
    DepartmentDTO toDTO(Department department);
}
