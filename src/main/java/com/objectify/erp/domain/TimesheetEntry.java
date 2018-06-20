package com.objectify.erp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class TimesheetEntry {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate workDate;

    private BigDecimal workDuration;

    @ManyToOne
    private Person person;

}
