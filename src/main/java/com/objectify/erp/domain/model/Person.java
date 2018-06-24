package com.objectify.erp.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "person")
    private List<TimesheetEntry> timesheetEntries;

}
