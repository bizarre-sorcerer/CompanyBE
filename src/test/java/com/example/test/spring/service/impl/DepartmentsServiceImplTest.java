package com.example.test.spring.service.impl;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.entities.Department;
import com.example.test.spring.mappers.DepartmentsMapper;
import com.example.test.spring.repositories.DepartmentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DepartmentsServiceImplTest {

    @InjectMocks
    private DepartmentsServiceImpl departmentsService;

    @Mock
    private DepartmentsRepository departmentsRepository;

    @Mock
    private DepartmentsMapper departmentsMapper;

    @Test
    void addDepartment(){
        // Arrange
        DepartmentDTO departmentDTO = DepartmentDTO.builder().
                departmentName("IT")
                .build();
        System.out.println("department " + departmentDTO);

        Department departmentEntity = new Department();
        departmentEntity.setDepartmentName("IT");

        when(departmentsMapper.toEntity(any(DepartmentDTO.class))).thenReturn(departmentEntity);
        when(departmentsMapper.toDTO(any(Department.class))).thenReturn(departmentDTO);
        when(departmentsRepository.save(any(Department.class))).thenReturn(departmentEntity);

        // Act
        DepartmentDTO savedDepartment = departmentsService.addDepartment(departmentDTO);

        // Assert
        assertNotNull(savedDepartment);
    }

    @Test
    void getDepartmentById() {
        // Arrange
        DepartmentDTO departmentDTO = DepartmentDTO.builder().
                departmentName("IT")
                .build();
        System.out.println("department " + departmentDTO);

        DepartmentDTO savedDepartment = departmentsService.addDepartment(departmentDTO);

        // Assert
        assertNotNull(savedDepartment);

        assertThrows(IllegalArgumentException.class, () -> {
            departmentsService.getDepartmentById(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            departmentsService.getDepartmentById(null);
        });
    }
}