package com.objectify.erp.dao;

import com.objectify.erp.domain.TimesheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetEntryDao extends JpaRepository<TimesheetEntry, Long> {

    public List<TimesheetEntry> findAllByPersonId(Long personId);

}
