package com.example.test.spring.service;

import com.example.test.spring.models.dtos.DepartmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentsService {
    Page<DepartmentDTO> getAllDepartments(Pageable pageable);

    DepartmentDTO getDepartmentById(Integer id);

    DepartmentDTO addDepartment(DepartmentDTO department);

    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long id);

    void deleteAll();

    void deleteDepartmentById(Integer id);
}
