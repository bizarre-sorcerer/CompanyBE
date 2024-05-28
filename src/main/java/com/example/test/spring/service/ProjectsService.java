package com.example.test.spring.service;

import com.example.test.spring.dto.ProjectDTO;

public interface ProjectsService {
    String getAll();

    String getById(Long id);

    String addProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);

    void deleteAll();

    void deleteById(Long id);
}

