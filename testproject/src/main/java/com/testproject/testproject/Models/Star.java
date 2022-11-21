package com.testproject.testproject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String Name;
    private String ClassStar;
    private Integer Lumen;

    public Star() {

    }

    public Star(String name, String classStar, Integer lumen) {
        this.Name = name;
        this.ClassStar = classStar;
        this.Lumen = lumen;
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
