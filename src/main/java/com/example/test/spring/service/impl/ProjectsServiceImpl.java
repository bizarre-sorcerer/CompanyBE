package com.example.test.spring.service.impl;

import com.example.test.spring.client.FeignService;
import com.example.test.spring.dto.ProjectDTO;
import com.example.test.spring.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {
    private final FeignService feignService;

    @Override
    public String getAll() {
        return feignService.getAll();
    }

    @Override
    public ProjectDTO getById(Long id){
        return feignService.getById(id);
    }

    @Override
    public ProjectDTO addProject(ProjectDTO projectDTO) {
        return feignService.addProject(projectDTO);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO){
        return feignService.updateProject(id, projectDTO);
    }

    @Override
    public void deleteAll() {
        feignService.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        feignService.deleteProject(id);
    }
}
