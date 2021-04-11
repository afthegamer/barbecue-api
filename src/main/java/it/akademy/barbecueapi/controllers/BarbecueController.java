package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.*;
import it.akademy.barbecueapi.models.Barbecue;

import org.springframework.beans.factory.annotation.*;
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
        List<Barbecue> gardens = barbecueDao.findAll();
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }
    @GetMapping("/?address={address}")
    public ResponseEntity<List<Barbecue>> getAllBarbecueByAddress(@PathVariable String address){
        List<Barbecue> gardens = barbecueDao.findAllByAddress(address);
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }
    @GetMapping("/?city={citys}")
    public ResponseEntity<List<Barbecue>> getAllBarbecueByCity(@PathVariable String city){
        List<Barbecue> gardens = barbecueDao.findAllByCity(city);
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }
    @GetMapping("/?country={country}")
    public ResponseEntity<List<Barbecue>> getAllBarbecueByCountry(@PathVariable String country){
        List<Barbecue> gardens = barbecueDao.findAllByCountry(country);
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Barbecue> addGarden(@RequestBody Barbecue barbecue){
        Barbecue addedGarden = barbecueDao.save(barbecue);
        return new ResponseEntity<>(addedGarden, HttpStatus.CREATED);
    }
}
