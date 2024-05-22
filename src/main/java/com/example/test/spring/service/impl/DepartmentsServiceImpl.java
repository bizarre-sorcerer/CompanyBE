package com.example.test.spring.service.impl;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.entities.Department;
import com.example.test.spring.mappers.DepartmentsMapper;
import com.example.test.spring.repositories.DepartmentsRepository;
import com.example.test.spring.service.DepartmentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    private final DepartmentsRepository departmentsRepository;
    private final DepartmentsMapper departmentsMapper;

    public DepartmentsServiceImpl(DepartmentsRepository departmentsRepository, DepartmentsMapper departmentsMapper) {
        this.departmentsRepository = departmentsRepository;
        this.departmentsMapper = departmentsMapper;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentsRepository.findAll();

        return departments.stream()
                .map(departmentsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer departmentId) {
        Optional<Department> departmentOptional = departmentsRepository.findById(departmentId);

        if (departmentOptional.isPresent()){
            Department department = departmentOptional.get();
            return departmentsMapper.toDTO(department);
        } else {
            return null;
        }
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentsMapper.toEntity(departmentDTO);
        Department saveDepartment = departmentsRepository.save(department);
        return departmentsMapper.toDTO(saveDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(Integer departmentId, DepartmentDTO departmentDTO) {
        Optional<Department> departmentOptional = departmentsRepository.findById(departmentId);

        if (departmentOptional.isPresent()){
            Department department = departmentOptional.get();
            departmentsMapper.toDTO(department);

            departmentsRepository.save(department);
            return departmentsMapper.toDTO(department);
        }
        return departmentDTO;
    }

    @Override
    public void deleteAll() {
        departmentsRepository.deleteAll();
    }

    @Override
    public void deleteDepartmentById(Integer employeeId) {
        departmentsRepository.deleteById(employeeId);
    }
}
