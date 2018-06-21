package com.objectify.erp.controller;

import com.objectify.erp.dao.PersonDao;
import com.objectify.erp.domain.Person;
import com.objectify.erp.dto.PersonDto;
import com.objectify.erp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findAll() {
        return personDao.findAll()
                .stream()
                .map(person -> PersonDto.from(person))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto create(@RequestParam("name") String name,
                            @RequestParam("surname") String surname) {

        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        Person savedPerson = personDao.save(person);

        return PersonDto.from(savedPerson);
    }

    @PutMapping(value = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto update(@PathVariable("id") Long id,
                            @RequestParam("name") String name,
                            @RequestParam("surname") String surname) {

        Person person = personService.updatePerson(id, name, surname);
        return PersonDto.from(person);
    }


}
