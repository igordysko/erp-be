package com.objectify.erp.domain.service;

import com.objectify.erp.domain.dao.PersonDao;
import com.objectify.erp.domain.model.Person;
import com.objectify.erp.domain.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional
    public Person updatePerson(Long id, String name, String surname) {
        Optional<Person> personOpt = personDao.findById(id);
        if (!personOpt.isPresent()) {
            throw new ResourceNotFoundException("Person does not exist. Id: " + id);
        }
        Person person = personOpt.get();
        person.setName(name);
        person.setSurname(surname);
        return personDao.save(person);
    }

}
