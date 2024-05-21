package com.example.test.spring.controllers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.service.EmployeeService;
import com.example.test.spring.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-employee-byId")
    public EmployeeDTO getEmployeeById(EmployeeDTO employeeDTO){
        return employeeService.getEmployeeById(employeeDTO.getId());
    }

    @PostMapping("/add-employee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update-employee")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/clear-all")
    public void clearAllEmployees() {
        employeeService.deleteAll();
    }

    @DeleteMapping("/delete-byId")
    public void deleteById(EmployeeDTO employeeDTO){
        employeeService.deleteEmployeeById(employeeDTO.getId());
    }
}
