package com.example.test.spring.service;

import com.example.test.spring.models.dtos.QualificationDTO;

import java.util.List;

public interface QualificationService {
    List<QualificationDTO> getAllQualifications();

    QualificationDTO getQualificationById(Integer qualificationId);

    QualificationDTO createQualification(QualificationDTO qualificationDTO);

    QualificationDTO updateQualification(QualificationDTO qualificationDTO);

    void deleteAll();

    void deleteEmployeeById(Integer employeeId);
}
