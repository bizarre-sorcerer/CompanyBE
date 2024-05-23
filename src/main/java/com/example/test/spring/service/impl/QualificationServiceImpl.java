package com.example.test.spring.service.impl;

import com.example.test.spring.dto.QualificationDTO;
import com.example.test.spring.entities.Department;
import com.example.test.spring.entities.Qualification;
import com.example.test.spring.mappers.QualificationMapper;
import com.example.test.spring.repositories.QualificationRepository;
import com.example.test.spring.service.QualificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository qualificationRepository;
    private final QualificationMapper qualificationMapper;

    public QualificationServiceImpl(QualificationRepository qualificationRepository, QualificationMapper qualificationMapper) {
        this.qualificationRepository = qualificationRepository;
        this.qualificationMapper = qualificationMapper;
    }

    @Override
    public List<QualificationDTO> getAllQualifications() {
        List<Qualification> qualifications = qualificationRepository.findAll();

        return qualifications.stream()
                .map(qualificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QualificationDTO getQualificationById(Integer qualificationId) {
        Optional<Qualification> qualificationOptional = qualificationRepository.findById(qualificationId);

        if (qualificationOptional.isPresent()){
            Qualification qualification = qualificationOptional.get();
            return qualificationMapper.toDTO(qualification);
        } else {
            return null;
        }
    }

    @Override
    public QualificationDTO createQualification(QualificationDTO qualificationDTO) {
        Qualification qualification = qualificationMapper.toEntity(qualificationDTO);
        Qualification saveQualification = qualificationRepository.save(qualification);
        return qualificationMapper.toDTO(saveQualification);
    }

    @Override
    public void deleteAll() {
        qualificationRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        qualificationRepository.deleteById(employeeId);
    }
}
