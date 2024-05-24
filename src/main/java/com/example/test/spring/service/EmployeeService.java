package com.example.test.spring.service;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<EmployeeDTO> getAllEmployees(Pageable pageable);

    EmployeeDTO getEmployeeById(Integer employeeID);

    EmployeeDTO createEmployee(EmployeeDTO employee);

    EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employeeDTO);

    void deleteAll();

    void deleteEmployeeById(Integer employeeId);
}
