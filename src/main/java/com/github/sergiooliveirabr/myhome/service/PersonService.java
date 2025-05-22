package com.github.sergiooliveirabr.myhome.service;

import com.github.sergiooliveirabr.myhome.entity.Person;
import com.github.sergiooliveirabr.myhome.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person findById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        throw new NoSuchElementException("Person with ID " + id + " not found");
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
