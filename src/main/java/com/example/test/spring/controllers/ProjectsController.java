package com.example.test.spring.controllers;

import com.example.test.spring.dto.ProjectDTO;
import com.example.test.spring.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectsController {
    private final ProjectsService projectsService;

    @GetMapping
    public String getAll() {
        return projectsService.getAll();
    }

    @GetMapping("{id}")
    public ProjectDTO getById(@PathVariable Long id){
        return projectsService.getById(id);
    }

    @PostMapping("add")
    public ProjectDTO addProject(@RequestBody ProjectDTO projectDTO){
        return projectsService.addProject(projectDTO);
    }

    @PutMapping("")
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO){
        return projectsService.updateProject(projectDTO);
    }

    @DeleteMapping("all")
    public void deleteAll(){
        projectsService.deleteAll();
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable Long id){
        projectsService.deleteById(id);
    }
}

