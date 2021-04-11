package it.akademy.barbecueapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Aliment {
    @Id
    private int id;

    private String name;

    @JsonManagedReference(value = "aliment-person")
    @ManyToOne
    private Person persons;

    @JsonManagedReference(value = "aliment-barbecue")
    @ManyToOne
    private Barbecue barbecue;

    private Aliment(){}

    private Aliment(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Barbecue getBarbecue() { return barbecue; }

    public void setBarbecue(Barbecue barbecue) { this.barbecue = barbecue; }

    public Person getPerson(){return persons;}

    public void setPerson(){this.persons=persons;}
}
