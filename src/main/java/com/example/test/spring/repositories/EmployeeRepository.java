package com.example.test.spring.repositories;

import com.example.test.spring.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(long id);

    Optional<Employee> findByFirstName(String firstName);
}