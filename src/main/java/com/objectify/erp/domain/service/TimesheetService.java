package com.objectify.erp.domain.service;

import com.objectify.erp.domain.dao.PersonDao;
import com.objectify.erp.domain.dao.TimesheetEntryDao;
import com.objectify.erp.domain.model.Person;
import com.objectify.erp.domain.model.TimesheetEntry;
import com.objectify.erp.domain.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TimesheetService {

    @Autowired
    private TimesheetEntryDao timesheetEntryDao;

    @Autowired
    private PersonDao personDao;

    @Transactional
    public TimesheetEntry create(Long personId, LocalDate workDate, BigDecimal workDuration) {
        Optional<Person> personOpt = personDao.findById(personId);
        if (!personOpt.isPresent()) {
            throw new ResourceNotFoundException("Person does not exist. Id: " + personId);
        }

        Person person = personOpt.get();
        TimesheetEntry timesheetEntry = new TimesheetEntry();
        timesheetEntry.setPerson(person);
        timesheetEntry.setWorkDate(workDate);
        timesheetEntry.setWorkDuration(workDuration);

        return timesheetEntryDao.save(timesheetEntry);
    }

    @Transactional
    public TimesheetEntry update(Long id, LocalDate workDate, BigDecimal workDuration) {

        Optional<TimesheetEntry> timesheetEntryOpt = timesheetEntryDao.findById(id);
        if (!timesheetEntryOpt.isPresent()) {
            throw new ResourceNotFoundException("TimesheetEntry does not exist. Id: " + id);
        }

        TimesheetEntry timesheetEntry = timesheetEntryOpt.get();
        timesheetEntry.setWorkDate(workDate);
        timesheetEntry.setWorkDuration(workDuration);
        return timesheetEntryDao.save(timesheetEntry);
    }

}
