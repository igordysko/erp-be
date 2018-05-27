package com.objectify.erp.domain;

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
