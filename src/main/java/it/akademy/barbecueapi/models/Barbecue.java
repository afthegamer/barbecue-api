package it.akademy.barbecueapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Barbecue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String date;
    private String address;
    private String city;
    private String country;

    @JsonManagedReference(value = "barbecue-person")
    @OneToMany
    private List<Person> persons;
    
    @JsonManagedReference(value= "aliment-barbecue")
    @OneToMany
    private List<Aliment> aliments;

    public Barbecue(){}

    public Barbecue(String date, String address, String city, String country){
        this.date = date;
        this.address = address;
        this.city = city;
        this.country = country;
        this.persons = new ArrayList<>();
        this.aliments = new ArrayList<>();
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getDate() {return date;}

    public void setName(String date) {this.date = date;}

    public List<Person> getPersons() { return persons; }

    public void setPersons(List<Person> persons){this.persons = persons;}

    public List<Aliment> getAliments() { return aliments;}

    public void setAliments(List<Aliment> aliments){this.aliments = aliments;}

    public String getAddress() { return address; }

    public void setAddress(String address){this.address=address;}

    public String getCity() { return city; }

    public void setCity(String city){ this.city=city;}

    public String getCountry() { return country; }

    public void setCountry(String country){this.country=country;}

}
