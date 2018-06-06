package com.objectify.erp.controller;

import com.objectify.erp.domain.Project;
import com.objectify.erp.dto.ProjectDto;
import com.objectify.erp.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @RequestMapping(value = "/projects", produces = "application/json")
    public List<ProjectDto> getAllProjects(HttpServletRequest request) {

        List<Project> projectEntities = projectDao.findAll();
        return projectEntities
                .stream()
                .map(entity -> new ProjectDto().setName(entity.getName()))
                .collect(Collectors.toList());

    }

}
