package com.testproject.testproject.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Scientist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;
    private String surname;
    private Date dateOfTheBirth;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="scientist_star",
                joinColumns = @JoinColumn (name="scientist_id"),
                inverseJoinColumns = @JoinColumn(name="star_id"))
    private List<Star> stars;

    public Scientist() {
    }

    public Scientist(String name, String surname, Date dateOfTheBirth, List<Star> stars) {
        this.name = name;
        this.surname = surname;
        this.dateOfTheBirth = dateOfTheBirth;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfTheBirth() {
        return dateOfTheBirth;
    }

    public void setDateOfTheBirth(Date dateOfTheBirth) {
        this.dateOfTheBirth = dateOfTheBirth;
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }
}
