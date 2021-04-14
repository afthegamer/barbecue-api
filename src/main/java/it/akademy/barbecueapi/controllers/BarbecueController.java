package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.AlimentDao;
import it.akademy.barbecueapi.dao.BarbecueDao;
import it.akademy.barbecueapi.dao.PersonDao;

import it.akademy.barbecueapi.models.Barbecue;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("barbecues")
public class BarbecueController {
    private final BarbecueDao barbecueDao;
    private final PersonDao personDao;
    private final AlimentDao alimentDao;

    @Autowired
    public BarbecueController(BarbecueDao barbecueDao, PersonDao personDao, AlimentDao alimentDao) {
        this.barbecueDao = barbecueDao;
        this.personDao = personDao;
        this.alimentDao = alimentDao;
    }

    @GetMapping
    public ResponseEntity<List<Barbecue>> getAllBarbecue(){
        List<Barbecue> barbecue = barbecueDao.findAll();
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }
    @GetMapping("/?address={address}")
    public ResponseEntity<List<Barbecue>> getAllBarbecueByAddress(@PathVariable String address){
        List<Barbecue> barbecue = barbecueDao.findAllByAddress(address);
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }
    @GetMapping("/?city={city}")
    public ResponseEntity<List<Barbecue>> getAllBarbecueByCity(@PathVariable String city){
        List<Barbecue> barbecue = barbecueDao.findAllByCity(city);
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }
    @GetMapping("/?country={country}")
    public ResponseEntity<List<Barbecue>> getAllBarbecueByCountry(@PathVariable String country){
        List<Barbecue> barbecue = barbecueDao.findAllByCountry(country);
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }


    @GetMapping("/?id={id}")
    public ResponseEntity<Barbecue> getBarbecueById(@PathVariable int id){
        Barbecue barbecue = barbecueDao.findById(id);
        if(barbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Barbecue> addBarbecue(@RequestBody Barbecue barbecue){
        Barbecue addedBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(addedBarbecue, HttpStatus.CREATED);
    }
}
