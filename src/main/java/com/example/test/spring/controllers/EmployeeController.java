package com.example.test.spring.controllers;

import com.example.test.spring.models.dtos.EmployeeDTO;
import com.example.test.spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Page<EmployeeDTO> getAllEmployees(Pageable pageable) {
        return employeeService.getAllEmployees(pageable);
    }

    @GetMapping("{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        return employeeService.updateEmployee(employeeDTO, id);
    }

    @DeleteMapping("/all")
    public void clearAllEmployees() {
        employeeService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }
}
