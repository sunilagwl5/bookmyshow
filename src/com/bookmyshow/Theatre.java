package com.bookmyshow;


import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Theatre {
    int id;
    City city;
    String address;
    List<Screen> screens;
    List<Show> shows;

    public Theatre(City city, String address, List<Screen> screens, List<Show> shows) {
        this.id = UUID.randomUUID().hashCode();
        this.city = city;
        this.address = address;
        this.screens = screens;
        this.shows = shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public City getCity() {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public int getId() { return id; }

}
