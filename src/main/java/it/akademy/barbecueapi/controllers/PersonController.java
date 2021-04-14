package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.AlimentDao;
import it.akademy.barbecueapi.dao.BarbecueDao;
import it.akademy.barbecueapi.dao.PersonDao;

import it.akademy.barbecueapi.models.Aliment;
import it.akademy.barbecueapi.models.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonDao personDao;
    private final AlimentDao alimentDao;

    @Autowired
    public PersonController(PersonDao personDao, AlimentDao alimentDao) {
        this.personDao = personDao;
        this.alimentDao = alimentDao;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> persons = personDao.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){
        Person person = personDao.findById(id);

        if(person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/{id}/aliments")
    public ResponseEntity<List<Aliment>> getAlimentsByPerson(@PathVariable int id){
        Person person = personDao.findById(id);

        if(person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Aliment> flowers = alimentDao.findAllByPerson(person);

        return new ResponseEntity<>(flowers, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person addedPerson = personDao.save(person);
        return new ResponseEntity<>(addedPerson, HttpStatus.CREATED);
    }
}
