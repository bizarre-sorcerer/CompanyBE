package com.example.test.spring.repositories;

import com.example.test.spring.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DepartmentsRepository extends JpaRepository<Department, UUID> { }
