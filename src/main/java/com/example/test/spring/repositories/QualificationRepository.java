package com.example.test.spring.repositories;

import com.example.test.spring.models.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
    Optional<Qualification> findById(Long qualificationId);
}
