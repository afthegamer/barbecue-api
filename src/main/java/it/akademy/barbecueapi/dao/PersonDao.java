package it.akademy.barbecueapi.dao;

import it.akademy.barbecueapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface PersonDao  extends JpaRepository<Person, Integer> {
    List<Person> findAll();

    Person findById(int id);

    Person save(Person person);

    void deleteById(int id);
}
