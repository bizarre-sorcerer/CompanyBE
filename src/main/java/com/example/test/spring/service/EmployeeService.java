package com.example.test.spring.service;

import com.example.test.spring.models.dtos.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<EmployeeDTO> getAllEmployees(Pageable pageable);

    EmployeeDTO getEmployeeById(Integer employeeID);

    EmployeeDTO createEmployee(EmployeeDTO employee);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id);

    void deleteAll();

    void deleteEmployeeById(Integer employeeId);
}
