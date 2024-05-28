package com.example.test.spring.service.impl;

import com.example.test.spring.dto.ProjectDTO;
import com.example.test.spring.service.ProjectsService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProjectsServiceImpl implements ProjectsService {
    private final RestClient restClient;

    public ProjectsServiceImpl() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8081/projects")
                .build();
    }

    @Override
    public String getAll() {
        return restClient.get()
                .uri("")
                .retrieve()
                .body(new ParameterizedTypeReference<String>() {});
    }

    @Override
    public String getById(Long id) {
        return restClient.get()
                .uri("/" + id)
                .retrieve()
                .body(new ParameterizedTypeReference<String>() {});
    }

    @Override
    public String addProject(ProjectDTO projectDTO) {
        return restClient.post()
                .uri("/add")
                .body(projectDTO)
                .retrieve()
                .body(new ParameterizedTypeReference<String>() {});
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO){
        return restClient.put()
                .uri(uriBuilder -> uriBuilder.path("/{id}")
                        .build(id))
                .body(projectDTO)
                .retrieve()
                .body(new ParameterizedTypeReference<ProjectDTO>() {});
    }

    @Override
    public void deleteAll() {
        restClient.delete()
                .uri("/all")
                .retrieve()
                .body(new ParameterizedTypeReference<String>() {});
    }

    @Override
    public void deleteById(Long id) {
        restClient.delete()
                .uri("/" + id)
                .retrieve()
                .body(new ParameterizedTypeReference<String>() {});
    }
}
