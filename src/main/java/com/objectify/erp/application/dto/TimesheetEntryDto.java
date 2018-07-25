package com.objectify.erp.application.dto;

import com.objectify.erp.domain.model.TimesheetEntry;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value.Immutable
public abstract class TimesheetEntryDto {

    public abstract Long getId();

    public abstract LocalDate getWorkDate();

    public abstract BigDecimal getWorkDuration();

    public static TimesheetEntryDto from(TimesheetEntry te) {
        return ImmutableTimesheetEntryDto
                .builder()
                .id(te.getId())
                .workDate(te.getWorkDate())
                .workDuration(te.getWorkDuration())
                .build();
    }
}
