package com.example.test.spring.controllers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.service.EmployeeService;
import com.example.test.spring.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeesMapper employeeMapper;

    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/clear-employees")
    public void clearAllEmployees() {
        employeeService.deleteAll();
    }
}
