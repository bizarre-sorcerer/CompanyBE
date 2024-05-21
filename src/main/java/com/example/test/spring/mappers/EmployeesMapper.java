package com.example.test.spring.mappers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeesMapper {
    Employee toEntity(EmployeeDTO employeeDTO);

    EmployeeDTO toDto(Employee employee);
}
