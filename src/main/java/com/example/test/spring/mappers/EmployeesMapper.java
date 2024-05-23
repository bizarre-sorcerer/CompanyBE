package com.example.test.spring.mappers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Employee;
import com.example.test.spring.entities.Qualification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeesMapper {

    @Mapping(target = "department", ignore = true)
    @Mapping(target = "qualification", ignore = true)
    @Mapping(target = "position", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);

    @Mapping(target = "department", source = "department")
    @Mapping(target = "qualification", source = "qualification")
    @Mapping(target = "position", source = "position")
    EmployeeDTO toDTO(Employee employee);
}
