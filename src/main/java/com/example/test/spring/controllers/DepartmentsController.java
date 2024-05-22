package com.example.test.spring.controllers;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments/")
@RequiredArgsConstructor
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @GetMapping("/")
    public List<DepartmentDTO> getAllEmployees() {
        return departmentsService.getAllDepartments();
    }

    @GetMapping("/get-department-byId/{employeeId}")
    public DepartmentDTO getEmployeeById(@PathVariable Integer departmentId, DepartmentDTO departmentDTO){
        return departmentsService.getDepartmentById(departmentId);
    }

    @PostMapping("/add-department")
    public DepartmentDTO addEmployee(@RequestBody DepartmentDTO departmentDTO) {
        return departmentsService.addDepartment(departmentDTO);
    }

    @PutMapping("/update-department/{employeeId}")
    public DepartmentDTO updateEmployee(@PathVariable Integer employeeId, @RequestBody DepartmentDTO departmentDTO){
        return departmentsService.updateDepartment(employeeId, departmentDTO);
    }

    @DeleteMapping("/clear-all")
    public void clearAllEmployees() {
        departmentsService.deleteAll();
    }

    @DeleteMapping("/delete-byId/{departmentId}")
    public void deleteById(@PathVariable Integer departmentId, DepartmentDTO departmentDTO){
        departmentsService.deleteDepartmentById(departmentId);
    }
}
