package com.objectify.erp.dto;

import com.objectify.erp.domain.Person;

public class PersonDto {

    private Long id;

    private String name;

    private String surname;

    public Long getId() {
        return id;
    }

    public PersonDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public static PersonDto from(Person person) {
        return new PersonDto().setId(person.getId()).setName(person.getName()).setSurname(person.getSurname());
    }
}
