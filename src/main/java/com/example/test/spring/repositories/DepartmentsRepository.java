package com.example.test.spring.repositories;

import com.example.test.spring.models.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findById(Long departmentId);
}
