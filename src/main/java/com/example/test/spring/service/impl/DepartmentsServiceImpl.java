package com.example.test.spring.service.impl;

import com.example.test.spring.models.dtos.DepartmentDTO;
import com.example.test.spring.models.entities.Department;
import com.example.test.spring.mappers.DepartmentsMapper;
import com.example.test.spring.repositories.DepartmentsRepository;
import com.example.test.spring.service.DepartmentsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentsService {

    private final DepartmentsRepository departmentsRepository;
    private final DepartmentsMapper departmentsMapper;

    @Override
    public Page<DepartmentDTO> getAllDepartments(Pageable pageable) {
        log.info("Getting all departments");

        Page<Department> departments = departmentsRepository.findAll(pageable);
        return departments.map(departmentsMapper::toDTO);
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id must be not null and a positive integer");
        }

        Department department = departmentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        return departmentsMapper.toDTO(department);
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentsMapper.toEntity(departmentDTO);
        Department saveDepartment = departmentsRepository.save(department);
        return departmentsMapper.toDTO(saveDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long id) {
        departmentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        Department updatedDepartment = departmentsMapper.toEntity(departmentDTO);
        Department savedDepartment = departmentsRepository.save(updatedDepartment);
        return departmentsMapper.toDTO(savedDepartment);
    }

    @Override
    public void deleteAll() {
        departmentsRepository.deleteAll();
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        departmentsRepository.deleteById(id);
    }
}

