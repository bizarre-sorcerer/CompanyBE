package com.example.test.spring.controllers;

import com.example.test.spring.dto.DepartmentDTO;
import com.example.test.spring.dto.QualificationDTO;
import com.example.test.spring.service.DepartmentsService;
import com.example.test.spring.service.QualificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualifications/")
@RequiredArgsConstructor
public class QualificationController {
    private final QualificationService qualifactionService;

    @GetMapping("/")
    public List<QualificationDTO> getAllQualifications() {
        return qualifactionService.getAllQualifications();
    }

    @GetMapping("/get-byId/{qualificationId}")
    public QualificationDTO getQualificationById(@PathVariable Integer qualificationId, QualificationDTO qualificationDTO){
        return qualifactionService.getQualificationById(qualificationId);
    }

    @PostMapping("/add")
    public QualificationDTO addQualification(@RequestBody QualificationDTO qualificationDTO) {
        return qualifactionService.createQualification(qualificationDTO);
    }

    @DeleteMapping("/delete-all")
    public void deleteAllQualification() {
        qualifactionService.deleteAll();
    }

    @DeleteMapping("/delete-byId/{departmentId}")
    public void deleteQualificationById(@PathVariable Integer departmentId, DepartmentDTO departmentDTO){
        qualifactionService.deleteEmployeeById(departmentId);
    }

}
