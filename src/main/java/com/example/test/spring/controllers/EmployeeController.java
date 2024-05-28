package com.example.test.spring.controllers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.service.EmployeeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
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
    public EmployeeDTO updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
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
