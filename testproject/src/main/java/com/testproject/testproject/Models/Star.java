package com.testproject.testproject.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String Name;
    private String ClassStar;
    private Integer Lumen;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="scientist_star",
               joinColumns = @JoinColumn(name="star_id"),
                inverseJoinColumns = @JoinColumn(name="scientist_id"))
    private List<Scientist> scientists;
    public Star() {

    }

    public Star(String name, String classStar, Integer lumen, List<Scientist> scientists) {
        Name = name;
        ClassStar = classStar;
        Lumen = lumen;
        this.scientists = scientists;
    }

    public List<Scientist> getScientists() {
        return scientists;
    }

    public void setScientists(List<Scientist> scientists) {
        this.scientists = scientists;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClassStar() {
        return ClassStar;
    }

    public void setClassStar(String classStar) {
        ClassStar = classStar;
    }

    public Integer getLumen() {
        return Lumen;
    }

    public void setLumen(Integer lumen) {
        Lumen = lumen;
    }
}
