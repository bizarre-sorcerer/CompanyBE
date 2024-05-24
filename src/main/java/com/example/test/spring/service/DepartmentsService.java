package com.example.test.spring.service;

import com.example.test.spring.dto.DepartmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentsService {
    Page<DepartmentDTO> getAllDepartments(Pageable pageable);

    DepartmentDTO getDepartmentById(Integer id);

    DepartmentDTO addDepartment(DepartmentDTO department);

    DepartmentDTO updateDepartment(Integer id, DepartmentDTO departmentDTO);

    void deleteAll();

    void deleteDepartmentById(Integer id);
}
