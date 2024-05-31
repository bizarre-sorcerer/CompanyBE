package com.example.test.spring.repositories;

import com.example.test.spring.entities.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentsRepositoryTest {

    @Autowired
    DepartmentsRepository departmentsRepository;

    @Test
    void AddDepartment_ReturnIt(){
        // Arrange
        Department department = Department.builder().
                departmentName("IT").
                build();

        // Act
        Department createdDepartment = departmentsRepository.save(department);

        // Assert
        assertNotNull(createdDepartment);
        assertTrue(createdDepartment instanceof Department);
    }
}