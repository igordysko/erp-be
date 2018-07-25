package com.objectify.erp.application.service;

import com.objectify.erp.application.dto.ProjectDto;
import com.objectify.erp.application.request.ProjectRequest;
import com.objectify.erp.domain.dao.ProjectDao;
import com.objectify.erp.domain.exception.ResourceNotFoundException;
import com.objectify.erp.domain.model.Customer;
import com.objectify.erp.domain.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private CustomerService customerService;

    @Transactional
    public ProjectDto createProject(ProjectRequest projectRequest) {
        Customer customer = customerService.findCustomerById(projectRequest.getCustomerId());
        Project project = setValuesToEntity(new Project(), customer, projectRequest);
        project = projectDao.save(project);
        return ProjectDto.from(project);
    }

    @Transactional
    public ProjectDto updateProject(Long projectId, ProjectRequest projectRequest) {
        Optional<Project> projectOpt = projectDao.findById(projectId);
        if (!projectOpt.isPresent()) {
            throw new ResourceNotFoundException("Project not found. Id: " + projectId);
        }
        Customer customer = customerService.findCustomerById(projectRequest.getCustomerId());
        Project project = setValuesToEntity(projectOpt.get(), customer, projectRequest);
        project = projectDao.save(project);
        return ProjectDto.from(project);
    }

    @Transactional
    public ProjectDto findProjectById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Customer id is null");
        }

        Optional<Project> projectOpt = projectDao.findById(id);
        if (!projectOpt.isPresent()) {
            throw new ResourceNotFoundException("Project does not exist. Id: " + id);
        }
        return ProjectDto.from(projectOpt.get());
    }

    @Transactional
    public void deleteProjectById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Customer id is null");
        }
        projectDao.deleteById(id);
    }

    private Project setValuesToEntity(Project project, Customer customer, ProjectRequest projectRequest) {
        project.setBudget(projectRequest.getBudget());
        project.setEndDate(projectRequest.getEndDate());
        project.setStartDate(projectRequest.getStartDate());
        project.setName(projectRequest.getName());
        project.setCustomer(customer);
        return project;
    }
}
