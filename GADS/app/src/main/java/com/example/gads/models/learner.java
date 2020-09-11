package com.example.gads.models;

import java.io.Serializable;

public class learner implements Serializable {


    private String name;
    private String hours;
    private String country;
    private String  badgeurl;

    public learner(String name, String hours, String country,String  badgeurl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeurl = badgeurl;
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }
}
