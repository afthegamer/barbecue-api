package it.akademy.barbecueapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import it.akademy.barbecueapi.models.Barbecue;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.List;

@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {
    @Override
    List<Barbecue> findAll();

    List<Barbecue> findAllByName(String date,String address, String city, String country);

    Barbecue findById(int id);

    Barbecue save(Barbecue barbecue);

    void deleteById(int id);
}
