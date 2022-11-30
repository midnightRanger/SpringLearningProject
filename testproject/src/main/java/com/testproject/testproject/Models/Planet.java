package com.testproject.testproject.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Null;

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
    @NonNull
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "planetcoreId")
    private PlanetCore planetCore;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Galactic galactic;

    public Planet() {

    }

    public Planet(String name, Double orbitalSpeed, Double rotation, Double tempinc, Double tempink, PlanetCore planetCore, Galactic galactic) {
        this.name = name;
        this.orbitalSpeed = orbitalSpeed;
        this.rotation = rotation;
        this.tempinc = tempinc;
        this.tempink = tempink;
        this.planetCore = planetCore;
        this.galactic = galactic;
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

    public PlanetCore getPlanetCore() {
        return planetCore;
    }

    public void setPlanetCore(PlanetCore planetCore) {
        this.planetCore = planetCore;
    }

    public Galactic getGalactic() {
        return galactic;
    }

    public void setGalactic(Galactic galactic) {
        this.galactic = galactic;
    }
}