package com.objectify.erp.application.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProjectRequest {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal estimatedCosts;
    private BigDecimal budget;
    private Long customerId;

    public String getName() {
        return name;
    }

    public ProjectRequest setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public ProjectRequest setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProjectRequest setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public BigDecimal getEstimatedCosts() {
        return estimatedCosts;
    }

    public ProjectRequest setEstimatedCosts(BigDecimal estimatedCosts) {
        this.estimatedCosts = estimatedCosts;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public ProjectRequest setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public ProjectRequest setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }
}
