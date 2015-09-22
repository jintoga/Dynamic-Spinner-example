package com.example.dat.dynamicdualspinnertest;

import java.util.ArrayList;

/**
 * Created by DAT on 9/22/2015.
 */
public class Country {
    private String code;
    private String name;
    ArrayList<City> listOfCities;

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getListOfCities() {
        return listOfCities;
    }

    public void setListOfCities(ArrayList<City> listOfCities) {
        this.listOfCities = listOfCities;
    }

    @Override
    public String toString() {
        return name;
    }
}
