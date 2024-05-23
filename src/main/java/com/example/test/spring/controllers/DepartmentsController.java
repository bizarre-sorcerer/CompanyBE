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
    public List<DepartmentDTO> getAllDepartments() {
        return departmentsService.getAllDepartments();
    }

    @GetMapping("/get-byId/{employeeId}")
    public DepartmentDTO getDepartmentById(@PathVariable Integer departmentId, DepartmentDTO departmentDTO){
        return departmentsService.getDepartmentById(departmentId);
    }

    @PostMapping("/add")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentsService.addDepartment(departmentDTO);
    }

    @PutMapping("/update/{employeeId}")
    public DepartmentDTO updateDepartment(@PathVariable Integer employeeId, @RequestBody DepartmentDTO departmentDTO){
        return departmentsService.updateDepartment(employeeId, departmentDTO);
    }

    @DeleteMapping("/delete-all")
    public void deleteAllDepartments() {
        departmentsService.deleteAll();
    }

    @DeleteMapping("/delete-byId/{departmentId}")
    public void deleteDepartmentById(@PathVariable Integer departmentId){
        departmentsService.deleteDepartmentById(departmentId);
    }
}
