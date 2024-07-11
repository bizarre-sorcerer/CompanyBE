package com.example.test.spring.mappers;

import com.example.test.spring.models.dtos.EmployeeDTO;
import com.example.test.spring.models.entities.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeesMapper {
    Employee toEntity(EmployeeDTO employeeDTO);

    EmployeeDTO toDTO(Employee employee);
}
