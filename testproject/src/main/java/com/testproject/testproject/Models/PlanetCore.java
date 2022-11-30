package com.testproject.testproject.Models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class PlanetCore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;

    @Min(value = 1000, message = "Укажите глубину, которая больше или равна значению 1000 км.")
    @Max(value = 20000, message = "Укажите глубину, которая меньше или равна значению 20000 км. ")
    private double depth;

    @Min(value = 1, message = "Укажите радиус, который больше или равен значению 1 тыс. км." )
    @Max(value = 100, message = "Укажите радиус, который меньше или равен значению 100 тыс. км.")
    private double radius;

    @Min(value = -10000, message = "Укажите значение больше -10000")
    @Max(value = 10000000, message = "Укажите значение меньше 10000000")
    private double tempinc;

    @Min(value = -1000, message = "Укажите давление больше -1000 ГПа")
    @Max(value = 10000000, message = "Укажите давление меньше 10000000 Гпа")
    private double pressure;

    @OneToOne(optional = true, mappedBy = "planetCore")
    private Planet coreOwner;

    public PlanetCore() {
    }

    public PlanetCore(String name, double depth, double radius, double tempinc, double pressure, Planet coreOwner) {
        this.name = name;
        this.depth = depth;
        this.radius = radius;
        this.tempinc = tempinc;
        this.pressure = pressure;
        this.coreOwner = coreOwner;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getTempinc() {
        return tempinc;
    }

    public void setTempinc(double tempinc) {
        this.tempinc = tempinc;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Planet getCoreOwner() {
        return coreOwner;
    }

    public void setCoreOwner(Planet coreOwner) {
        this.coreOwner = coreOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
