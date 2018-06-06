package com.objectify.erp.security;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class ApplicationUser {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String password;

}
