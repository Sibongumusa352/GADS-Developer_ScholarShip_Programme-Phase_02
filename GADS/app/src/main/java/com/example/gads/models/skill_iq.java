package com.example.gads.models;

import java.io.Serializable;

public class skill_iq implements Serializable {

    private String name;
    private String score;
    private String country;
    private String badgeurl;

    public skill_iq(String name, String score, String country,String badgeurl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeurl = badgeurl;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }
}
