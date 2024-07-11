package com.example.test.spring.service;

import com.example.test.spring.models.dtos.ProjectDTO;

public interface ProjectsService {
    String getAll();

    ProjectDTO getById(Long id);

    ProjectDTO addProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO, Long id);

    void deleteAll();

    void deleteById(Long id);
}

