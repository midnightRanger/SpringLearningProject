package com.testproject.testproject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Galactic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;
    private double diametr;
    private double weight;
    private double rotationSpeed;
    private double lumen;

    public Galactic(String name, double diametr, double weight, double rotationSpeed, double lumen) {
        this.name = name;
        this.diametr = diametr;
        this.weight = weight;
        this.rotationSpeed = rotationSpeed;
        this.lumen = lumen;
    }

    public Galactic() {

    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiametr() {
        return diametr;
    }

    public void setDiametr(double diametr) {
        this.diametr = diametr;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(double rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public double getLumen() {
        return lumen;
    }

    public void setLumen(double lumen) {
        this.lumen = lumen;
    }
}
