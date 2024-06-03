package com.example.test.spring.service;

import com.example.test.spring.dto.ProjectDTO;
import org.springframework.data.domain.Page;

public interface ProjectsService {
    String getAll();

    ProjectDTO getById(Long id);

    ProjectDTO addProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO);

    void deleteAll();

    void deleteById(Long id);
}

