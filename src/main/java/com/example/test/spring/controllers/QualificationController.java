package com.example.test.spring.controllers;

import com.example.test.spring.dto.QualificationDTO;
import com.example.test.spring.service.QualificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualifications")
@RequiredArgsConstructor
public class QualificationController {
    private final QualificationService qualifactionService;

    @GetMapping
    public List<QualificationDTO> getAllQualifications() {
        return qualifactionService.getAllQualifications();
    }

    @GetMapping("/{id}")
    public QualificationDTO getQualificationById(@PathVariable Integer id){
        return qualifactionService.getQualificationById(id);
    }

    @PostMapping("/add")
    public QualificationDTO addQualification(@RequestBody QualificationDTO qualificationDTO) {
        return qualifactionService.createQualification(qualificationDTO);
    }

    @DeleteMapping("/all")
    public void deleteAllQualification() {
        qualifactionService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteQualificationById(@PathVariable Integer id){
        qualifactionService.deleteEmployeeById(id);
    }

}
