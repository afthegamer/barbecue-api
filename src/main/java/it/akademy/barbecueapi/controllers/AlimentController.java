package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.AlimentDao;
import it.akademy.barbecueapi.models.Aliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aliment")
public class AlimentController {
    private final AlimentDao alimentDao;

    @Autowired
    public AlimentController(AlimentDao alimentDao) { this.alimentDao = alimentDao; }

    @GetMapping
    public ResponseEntity<List<Aliment>> getAllAliment(){
        List<Aliment> aliments = alimentDao.findAll();
        return new ResponseEntity<>(aliments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aliment> getById(@PathVariable int id){
        Aliment aliment = alimentDao.findById(id);
        if(aliment == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aliment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aliment> createAliment(@RequestBody Aliment aliment){
        alimentDao.save(aliment);
        return new ResponseEntity<>(aliment, HttpStatus.CREATED);
    }
}
