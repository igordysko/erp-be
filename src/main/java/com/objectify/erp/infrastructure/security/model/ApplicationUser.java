package com.objectify.erp.infrastructure.security.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class ApplicationUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    private String password;

    @ElementCollection(targetClass = SecurityRole.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<SecurityRole> roles;

}
