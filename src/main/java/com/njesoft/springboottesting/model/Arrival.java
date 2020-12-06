package com.njesoft.springboottesting.model;

import javax.persistence.*;

@Entity
@Table(name = "arrival")
public class Arrival {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String city;

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
