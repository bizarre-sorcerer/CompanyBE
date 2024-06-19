package com.example.test.spring.controllers;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @GetMapping
    public Page<DepartmentDTO> getAllDepartments(Pageable pageable) {
        log.info(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
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

    @PutMapping("/")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentsService.updateDepartment(departmentDTO);
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
