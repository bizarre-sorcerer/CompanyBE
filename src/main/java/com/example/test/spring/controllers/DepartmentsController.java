package com.example.test.spring.controllers;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @GetMapping
    public Page<DepartmentDTO> getAllDepartments(Pageable pageable) {
        return departmentsService.getAllDepartments(pageable);
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Integer id){
        return departmentsService.getDepartmentById(id);
    }

    @PostMapping("/add")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentsService.addDepartment(departmentDTO);
    }

    @PutMapping("/{id}")
    public DepartmentDTO updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDTO departmentDTO){
        return departmentsService.updateDepartment(id, departmentDTO);
    }

    @DeleteMapping("/all")
    public void deleteAllDepartments() {
        departmentsService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Integer id){
        departmentsService.deleteDepartmentById(id);
    }
}
