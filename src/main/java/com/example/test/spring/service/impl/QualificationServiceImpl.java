package com.example.test.spring.service.impl;

import com.example.test.spring.dto.QualificationDTO;
import com.example.test.spring.entities.Department;
import com.example.test.spring.entities.Qualification;
import com.example.test.spring.mappers.QualificationMapper;
import com.example.test.spring.repositories.QualificationRepository;
import com.example.test.spring.service.QualificationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository qualificationRepository;
    private final QualificationMapper qualificationMapper;

    @Override
    public List<QualificationDTO> getAllQualifications() {
        List<Qualification> qualifications = qualificationRepository.findAll();

        return qualifications.stream()
                .map(qualificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QualificationDTO getQualificationById(Integer id) {
        Qualification qualification = qualificationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        return qualificationMapper.toDTO(qualification);
    }

    @Override
    public QualificationDTO createQualification(QualificationDTO qualificationDTO) {
        Qualification qualification = qualificationMapper.toEntity(qualificationDTO);
        Qualification saveQualification = qualificationRepository.save(qualification);
        return qualificationMapper.toDTO(saveQualification);
    }

    @Override
    public QualificationDTO updateQualification(QualificationDTO qualificationDTO){
        Integer id = qualificationDTO.getId();
        qualificationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Qualification not found with id: " + id));
        Qualification updatedQualification = qualificationMapper.toEntity(qualificationDTO);
        Qualification savedQualification = qualificationRepository.save(updatedQualification);
        return qualificationMapper.toDTO(savedQualification);
    }

    @Override
    public void deleteAll() {
        qualificationRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        qualificationRepository.deleteById(id);
    }
}
