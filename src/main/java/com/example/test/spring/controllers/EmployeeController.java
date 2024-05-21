package com.example.test.spring.controllers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.service.EmployeeService;
import com.example.test.spring.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-employee-byId/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable UUID employeeId, EmployeeDTO employeeDTO){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/add-employee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update-employee/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable UUID employeeId, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeId, employeeDTO);
    }

    @DeleteMapping("/clear-all")
    public void clearAllEmployees() {
        employeeService.deleteAll();
    }

    @DeleteMapping("/delete-byId/{employeeId}")
    public void deleteById(@PathVariable UUID employeeId, EmployeeDTO employeeDTO){
        employeeService.deleteEmployeeById(employeeId);
    }
}
