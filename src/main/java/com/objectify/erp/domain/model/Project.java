package com.objectify.erp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "project")
    private List<Cost> costs;
}
