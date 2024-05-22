package com.example.test.spring.service;

import com.example.test.spring.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Integer id);

    DepartmentDTO addDepartment(DepartmentDTO department);

    DepartmentDTO updateDepartment(Integer id, DepartmentDTO departmentDTO);

    void deleteAll();

    void deleteDepartmentById(Integer id);
}
