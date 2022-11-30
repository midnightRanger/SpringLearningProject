package com.testproject.testproject.Models.ModelView;

public class PlanetView {

    private String name;
    private Double orbitalSpeed;
    private Double rotation;
    private Double tempinc;
    private Double tempink;
    private double radius;

    public PlanetView(String name, Double orbitalSpeed, Double rotation, Double tempinc, Double tempink, double radius) {
        this.name = name;
        this.orbitalSpeed = orbitalSpeed;
        this.rotation = rotation;
        this.tempinc = tempinc;
        this.tempink = tempink;
        this.radius = radius;
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
