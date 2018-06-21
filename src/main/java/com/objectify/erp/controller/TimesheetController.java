package com.objectify.erp.controller;

import com.objectify.erp.dao.TimesheetEntryDao;
import com.objectify.erp.domain.Customer;
import com.objectify.erp.domain.TimesheetEntry;
import com.objectify.erp.dto.CustomerDto;
import com.objectify.erp.dto.TimesheetEntryDto;
import com.objectify.erp.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TimesheetController {

    @Autowired
    private TimesheetEntryDao timesheetEntryDao;

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping(value = "/timesheet-entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimesheetEntryDto> findTimesheetEntries(Long personId) {
        List<TimesheetEntryDto> timesheetEntryDtos = timesheetEntryDao
                .findAllByPersonId(personId)
                .stream()
                .map(te -> TimesheetEntryDto.from(te))
                .collect(Collectors.toList());

        return timesheetEntryDtos;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/timesheet-entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimesheetEntryDto create(@RequestParam("personId") Long personId,
                                    @RequestParam("workDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate workDate,
                                    @RequestParam("workDuration") BigDecimal workDuration) {

        TimesheetEntry timesheetEntry = timesheetService.create(personId, workDate, workDuration);
        return TimesheetEntryDto.from(timesheetEntry);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/timesheet-entries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimesheetEntryDto update(@PathVariable Long id,
                                    @RequestParam("workDate")
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate workDate,
                                    @RequestParam("workDuration") BigDecimal workDuration) {

        TimesheetEntry timesheetEntry = timesheetService.update(id, workDate, workDuration);
        return TimesheetEntryDto.from(timesheetEntry);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/timesheet-entries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        timesheetEntryDao.deleteById(id);
    }

}
