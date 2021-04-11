package it.akademy.barbecueapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;

    @JsonManagedReference(value = "aliment-barbecue")
    @ManyToOne
    private List<Aliment> aliments;

    @JsonManagedReference(value = "barbecue-person")
    @ManyToOne
    private Barbecue barbecue;

    public Person(){}

    public Person(String lastName, String firstName){
        this.lastName = lastName;
        this.firstName= firstName;
        this.aliments = new ArrayList<>();
    }

    public int getId() { return id; }

    public void setId(int id){this.id = id;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Aliment> getAliments() { return aliments; }

    public void setAliments (List<Aliment> aliments){this.aliments = aliments;}
}
