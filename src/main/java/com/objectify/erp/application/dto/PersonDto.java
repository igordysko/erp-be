package com.objectify.erp.application.dto;

import com.objectify.erp.domain.model.Person;
import org.immutables.value.Value;

@Value.Immutable
public abstract class PersonDto {

    public abstract Long getId();

    public abstract String getName();

    public abstract String getSurname();

    public static PersonDto from(Person person) {
        return ImmutablePersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .build();
    }
}
