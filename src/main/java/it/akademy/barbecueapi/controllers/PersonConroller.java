package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.*;
import it.akademy.barbecueapi.models.Person;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonConroller {
    private final PersonDao personDao;
    private final AlimentDao alimentDao;

    @Autowired
    public PersonConroller(BarbecueDao barbecueDao, PersonDao personDao, AlimentDao alimentDao) {
        this.personDao = personDao;
        this.alimentDao = alimentDao;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> persons = personDao.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
