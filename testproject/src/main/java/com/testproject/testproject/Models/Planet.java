package com.testproject.testproject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;
    private Double orbitalSpeed;
    private Double rotation;
    private Double tempinc;
    private Double tempink;

    public Planet() {

    }

    public Planet(String name, Double orbitalSpeed, Double rotation, Double tempinc, Double tempink) {
        this.name = name;
        this.orbitalSpeed = orbitalSpeed;
        this.rotation = rotation;
        this.tempinc = tempinc;
        this.tempink = tempink;
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

    public Double getOrbitalSpeed() {
        return orbitalSpeed;
    }

    public void setOrbitalSpeed(Double orbitalSpeed) {
        this.orbitalSpeed = orbitalSpeed;
    }

    public Double getRotation() {
        return rotation;
    }

    public void setRotation(Double rotation) {
        this.rotation = rotation;
    }

    public Double getTempinc() {
        return tempinc;
    }

    public void setTempinc(Double tempinc) {
        this.tempinc = tempinc;
    }

    public Double getTempink() {
        return tempink;
    }

    public void setTempink(Double tempink) {
        this.tempink = tempink;
    }
}