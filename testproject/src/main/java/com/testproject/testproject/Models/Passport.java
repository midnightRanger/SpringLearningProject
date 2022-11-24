package com.testproject.testproject.Models;

import javax.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    private Long Series;
    private Long Number;

    @OneToOne(optional = true, mappedBy= "passport")
    private User user;

    public Passport() {
    }

    public Passport(Long series, Long number, User user) {
        Series = series;
        Number = number;
        this.user = user;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Long getSeries() {
        return Series;
    }

    public void setSeries(Long series) {
        Series = series;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
