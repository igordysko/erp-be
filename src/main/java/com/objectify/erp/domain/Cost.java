package com.objectify.erp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Cost {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate taxationDate;

    private Month deliveryMonth;

    private BigDecimal quantity;

    private MeasureUnit measureUnit;

    private BigDecimal unitPrice;

    private String description;

    private String note;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Person recipient;

    private boolean appliesToProfitCalculation;

}
