package com.example.test.spring.repositories;

import com.example.test.spring.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Integer> { }
