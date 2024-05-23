package com.example.test.spring.service;

import com.example.test.spring.dto.QualificationDTO;

import java.util.List;

public interface QualificationService {
    List<QualificationDTO> getAllQualifications();

    QualificationDTO getQualificationById(Integer qualificationId);

    QualificationDTO createQualification(QualificationDTO qualificationDTO);

    void deleteAll();

    void deleteEmployeeById(Integer employeeId);
}
