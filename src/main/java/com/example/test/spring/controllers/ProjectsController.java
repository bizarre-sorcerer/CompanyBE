package com.example.test.spring.controllers;

import com.example.test.spring.models.dtos.ProjectDTO;
import com.example.test.spring.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectsController {
    private final ProjectsService projectsService;

    @GetMapping
    public String getAll() {
        return projectsService.getAll();
    }

    @GetMapping("/{id}")
    public ProjectDTO getById(@PathVariable Long id){
        return projectsService.getById(id);
    }

    @PostMapping("/add")
    public ProjectDTO addProject(@RequestBody ProjectDTO projectDTO){
        return projectsService.addProject(projectDTO);
    }

    @PutMapping("/{id}")
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable Long id){
        return projectsService.updateProject(projectDTO, id);
    }

    @DeleteMapping("/all")
    public void deleteAll(){
        projectsService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        projectsService.deleteById(id);
    }
}

