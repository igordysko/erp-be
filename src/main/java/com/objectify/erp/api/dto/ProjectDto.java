package com.objectify.erp.api.dto;

import com.objectify.erp.domain.dao.CustomerDao;
import com.objectify.erp.domain.model.Project;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Nullable;

@Value.Immutable
public abstract class ProjectDto {

    public abstract Long getId();

    public abstract String getName();

    @Nullable
    public abstract LocalDate getStartDate();

    @Nullable
    public abstract LocalDate getEndDate();

    @Nullable
    public abstract BigDecimal getEstimatedCosts();

    @Nullable
    public abstract BigDecimal getBudget();

    @Nullable
    public abstract CustomerDto getCustomer();

    public static ProjectDto from(Project project) {
        return ImmutableProjectDto
                .builder()
                .id(project.getId())
                .name(project.getName())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .estimatedCosts(project.getEstimatedCosts())
                .budget(project.getBudget())
                .customer(CustomerDto.from(project.getCustomer()))
                .build();
    }

    public Project setValuesToEntity(Project project) {
        project.setBudget(getBudget());
        project.setEndDate(getEndDate());
        project.setStartDate(getStartDate());
        project.setName(getName());
        return project;
    }

}
