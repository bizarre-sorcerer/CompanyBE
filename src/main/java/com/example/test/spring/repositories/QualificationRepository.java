package com.example.test.spring.repositories;

import com.example.test.spring.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
}
