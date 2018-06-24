package com.objectify.erp.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Income {

    @Id
    @GeneratedValue
    private Long id;

}
