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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
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
    void getAll(){
        // Arrange
        Pageable pageable = Pageable.ofSize(10).withPage(0); // Example pageable

        List<Department> departmentEntities = new ArrayList<>();
        departmentEntities.add(createDepartmentEntity());
        departmentEntities.add(createDepartmentEntity());

        Page<Department> departmentPage = new PageImpl<>(departmentEntities);

        DepartmentDTO departmentDTO1 = createDepartmentDTO();
        DepartmentDTO departmentDTO2 = createDepartmentDTO();

        when(departmentsRepository.findAll(pageable)).thenReturn(departmentPage);
        when(departmentsMapper.toDTO(departmentEntities.get(0))).thenReturn(departmentDTO1);
        when(departmentsMapper.toDTO(departmentEntities.get(1))).thenReturn(departmentDTO2);

        // Act
        Page<DepartmentDTO> result = departmentsService.getAllDepartments(pageable);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertEquals("IT", result.getContent().get(0).getDepartmentName());
        assertEquals("IT", result.getContent().get(1).getDepartmentName());
    }

    @Test
    void getById_ReturnsDepartment() {
        // Arrange
        Department departmentEntity = createDepartmentEntity();
        DepartmentDTO departmentDTO = createDepartmentDTO();

        Optional<Department> optionalDepartment = Optional.of(departmentEntity);

        when(departmentsMapper.toDTO(any(Department.class))).thenReturn(departmentDTO);
        when(departmentsMapper.toEntity(any(DepartmentDTO.class))).thenReturn(departmentEntity);
        when(departmentsRepository.save(any(Department.class))).thenReturn(departmentEntity);
        when(departmentsRepository.findById(anyInt())).thenReturn(optionalDepartment);

        // Act
        departmentsService.addDepartment(departmentDTO);
        DepartmentDTO retrievedDepartment = departmentsService.getDepartmentById(1);

        // Assert
        assertNotNull(retrievedDepartment);
    }

    @Test
    void getById_NullId(){
        assertThrows(IllegalArgumentException.class, () -> {
            departmentsService.getDepartmentById(null);
        });
    }

    @Test
    void getById_nonexistentId(){
        // Arrange
        Department departmentEntity = createDepartmentEntity();
        DepartmentDTO departmentDTO = createDepartmentDTO();

        Optional<Department> optionalDepartment = Optional.of(departmentEntity);

        when(departmentsMapper.toDTO(any(Department.class))).thenReturn(departmentDTO);
        when(departmentsRepository.findById(anyInt())).thenReturn(optionalDepartment);

        // Act
        DepartmentDTO retrievedDepartment = departmentsService.getDepartmentById(999);

        // Assert
        assertNotNull(retrievedDepartment);
    }

    @Test
    void addDepartment(){
        // Arrange
        Department departmentEntity = createDepartmentEntity();
        DepartmentDTO departmentDTO = createDepartmentDTO();

        when(departmentsMapper.toEntity(any(DepartmentDTO.class))).thenReturn(departmentEntity);
        when(departmentsMapper.toDTO(any(Department.class))).thenReturn(departmentDTO);
        when(departmentsRepository.save(any(Department.class))).thenReturn(departmentEntity);

        // Act
        DepartmentDTO savedDepartment = departmentsService.addDepartment(departmentDTO);

        // Assert
        assertNotNull(savedDepartment);
    }

    @Test
    void updateDepartment(){
        Department departmentEntity = createDepartmentEntity();
        DepartmentDTO departmentDTO = createDepartmentDTO();
        DepartmentDTO updatedDepartmentData = DepartmentDTO.builder().
                departmentName("New Value")
                .build();

        Optional<Department> optionalDepartment = Optional.of(departmentEntity);

        when(departmentsRepository.findById(anyInt())).thenReturn(optionalDepartment);
        when(departmentsRepository.save(any(Department.class))).thenReturn(departmentEntity);
        when(departmentsMapper.toEntity(any(DepartmentDTO.class))).thenReturn(departmentEntity);
        when(departmentsMapper.toDTO(any(Department.class))).thenReturn(departmentDTO);

        System.out.println(updatedDepartmentData.getDepartmentName());

        DepartmentDTO addedDepartment = departmentsService.addDepartment(departmentDTO);
        System.out.println(departmentsService.getDepartmentById(1).getDepartmentName());

        DepartmentDTO updatedDepartment = departmentsService.updateDepartment(updatedDepartmentData);
        System.out.println(updatedDepartment.getDepartmentName());

        DepartmentDTO toCheck = departmentsService.getDepartmentById(1);

        assertInstanceOf(DepartmentDTO.class, updatedDepartment);
        assertNotNull(updatedDepartment);
        assertSame("New Value", toCheck.getDepartmentName());
    }

    @Test
    void deleteAll(){

    }

    @Test
    void deleteById(){}


    private Department createDepartmentEntity() {
        return Department.builder()
                .id(1)
                .departmentName("IT")
                .build();
    }

    private DepartmentDTO createDepartmentDTO() {
        return DepartmentDTO.builder()
                .departmentName("IT")
                .build();
    }
}