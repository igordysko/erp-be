package com.objectify.erp.controller;

import com.objectify.erp.domain.Project;
import com.objectify.erp.dto.ProjectDto;
import com.objectify.erp.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/projects", produces = "application/json")
    public List<ProjectDto> getAllProjects(HttpServletRequest request) {

        List<Project> projectEntities = projectRepository.findAll();
        return projectEntities
                .stream()
                .map(entity -> new ProjectDto().setName(entity.getName()))
                .collect(Collectors.toList());

    }

}
