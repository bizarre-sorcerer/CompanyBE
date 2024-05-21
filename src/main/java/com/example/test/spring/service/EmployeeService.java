package com.example.test.spring.service;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(UUID employeeID);

    EmployeeDTO createEmployee(EmployeeDTO employee);

    EmployeeDTO updateEmployee(UUID employeeId, EmployeeDTO employeeDTO);

    void deleteAll();

    void deleteEmployeeById(UUID employeeId);
}
