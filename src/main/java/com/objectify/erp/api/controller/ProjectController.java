package com.objectify.erp.api.controller;

import com.objectify.erp.api.dto.ImmutableProjectDto;
import com.objectify.erp.api.dto.ProjectDto;
import com.objectify.erp.api.dto.ProjectRequest;
import com.objectify.erp.api.service.ProjectService;
import com.objectify.erp.domain.dao.ProjectDao;
import com.objectify.erp.domain.exception.ResourceNotFoundException;
import com.objectify.erp.domain.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectDto> findAll() {

        List<Project> projectEntities = projectDao.findAll();
        return projectEntities
                .stream()
                .map(entity -> ProjectDto.from(entity))
                .collect(Collectors.toList());

    }

    @GetMapping(value = "/projects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDto find(@PathVariable Long id) {

        Optional<Project> projectOpt = projectDao.findById(id);
        if (!projectOpt.isPresent()) {
            throw new ResourceNotFoundException("Project does not exist. Id: " + id);
        }
        return ProjectDto.from(projectOpt.get());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDto create(@RequestBody ProjectRequest projectRequest) {
        return projectService.createProject(projectRequest);
    }

    @PutMapping(value = "/projects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDto update(@PathVariable Long id,
                             @RequestBody ProjectDto project) {

        return projectService.updateProject(id, project);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/projects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        projectDao.deleteById(id);
    }

}
