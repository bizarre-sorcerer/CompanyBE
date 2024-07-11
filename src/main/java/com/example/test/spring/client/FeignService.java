package com.example.test.spring.client;

import com.example.test.spring.models.dtos.ProjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "projectsClient", url="http://localhost:8081/projects")
public interface FeignService {

    @GetMapping
    String getAll();

    @GetMapping("{id}")
    ProjectDTO getById(@PathVariable Long id);

    @PostMapping("add")
    ProjectDTO addProject(@RequestBody ProjectDTO projectDTO);

    @PutMapping("{id}")
    ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable Long id);

    @DeleteMapping("/all")
    void deleteAll();

    @DeleteMapping("{id}")
    void deleteProject(@PathVariable Long id);
}
