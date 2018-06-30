package com.objectify.erp.api.service;

import com.objectify.erp.api.dto.ProjectDto;
import com.objectify.erp.api.dto.ProjectRequest;
import com.objectify.erp.domain.dao.CustomerDao;
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
    private CustomerDao customerDao;

    @Transactional
    public ProjectDto createProject(ProjectRequest projectRequest) {
        Long customerId = projectRequest.getCustomerId();
        if (customerId == null) {
            throw new IllegalArgumentException("Customer id is null");
        }

        Optional<Customer> customerOpt = customerDao.findById(customerId);
        if (!customerOpt.isPresent()) {
            throw new ResourceNotFoundException("Customer not found. Id: " + customerId);
        }

        Project project = new Project();
        project.setBudget(projectRequest.getBudget());
        project.setEndDate(projectRequest.getEndDate());
        project.setStartDate(projectRequest.getStartDate());
        project.setName(projectRequest.getName());
        project.setCustomer(customerOpt.get());
        project = projectDao.save(project);
        return ProjectDto.from(project);
    }

    @Transactional
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
        Optional<Project> projectOpt = projectDao.findById(projectId);
        if (!projectOpt.isPresent()) {
            throw new ResourceNotFoundException("Project not found. Id: " + projectId);
        }

        Project project = projectDto.setValuesToEntity(projectOpt.get());
        project = projectDao.save(project);
        return ProjectDto.from(project);
    }

}
