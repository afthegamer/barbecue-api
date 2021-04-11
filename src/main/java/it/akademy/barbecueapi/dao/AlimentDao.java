package it.akademy.barbecueapi.dao;

import it.akademy.barbecueapi.models.Aliment;
import it.akademy.barbecueapi.models.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentDao extends JpaRepository<Aliment, Integer> {
    @Override
    List<Aliment> findAll();

    List<Aliment> findAllPerson(Person person);

    Aliment findById(int id);

    Aliment save(Aliment aliment);
    void deleteById(int id);
}
