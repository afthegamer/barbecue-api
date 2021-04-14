package it.akademy.barbecueapi.dao;

import it.akademy.barbecueapi.models.Aliment;
import it.akademy.barbecueapi.models.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentDao extends JpaRepository<Aliment, Integer> {

    @Override
    List<Aliment> findAll();

    List<Aliment> findAllByPerson(Person person);

    Aliment findById(int id);

    Aliment save(Aliment aliment);

    void deleteById(int id);
}
