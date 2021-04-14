package it.akademy.barbecueapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import it.akademy.barbecueapi.models.Barbecue;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.List;

@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {

    List<Barbecue> findAll();

    List<Barbecue> findAllByDate(String date);
    List<Barbecue> findAllByAddress(String address);
    List<Barbecue> findAllByCity(String city);
    List<Barbecue> findAllByCountry(String country);


    Barbecue findById(int id);

    Barbecue save(Barbecue barbecue);

    void deleteById(int id);
}
