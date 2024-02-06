package com.bookmyshow;

import java.util.UUID;

public class City {
    int id;
    String name;
    String state;

    public City(String name, String state) {
        this.name = name;
        this.id = UUID.randomUUID().hashCode();
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
