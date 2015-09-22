package com.example.dat.dynamicdualspinnertest;

/**
 * Created by DAT on 9/22/2015.
 */
public class City {
    private String code;
    private String name;

    public City() {
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

    @Override
    public String toString() {
        return name;
    }
}
