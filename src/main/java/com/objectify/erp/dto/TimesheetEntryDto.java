package com.objectify.erp.dto;

import com.objectify.erp.domain.TimesheetEntry;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TimesheetEntryDto {

    private Long id;

    private LocalDate workDate;

    private BigDecimal workDuration;

    public Long getId() {
        return id;
    }

    public TimesheetEntryDto setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public TimesheetEntryDto setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
        return this;
    }

    public BigDecimal getWorkDuration() {
        return workDuration;
    }

    public TimesheetEntryDto setWorkDuration(BigDecimal workDuration) {
        this.workDuration = workDuration;
        return this;
    }

    public static TimesheetEntryDto from(TimesheetEntry te) {
        return new TimesheetEntryDto().setId(te.getId()).setWorkDate(te.getWorkDate()).setWorkDuration(te.getWorkDuration());
    }
}
