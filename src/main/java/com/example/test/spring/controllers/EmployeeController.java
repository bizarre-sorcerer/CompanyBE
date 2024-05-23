package com.example.test.spring.controllers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-byId/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer employeeId, EmployeeDTO employeeDTO){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeId, employeeDTO);
    }

    @DeleteMapping("/delete-all")
    public void clearAllEmployees() {
        employeeService.deleteAll();
    }

    @DeleteMapping("/delete-byId/{employeeId}")
    public void deleteById(@PathVariable Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }
}
