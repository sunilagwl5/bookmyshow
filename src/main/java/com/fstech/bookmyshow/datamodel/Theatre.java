package com.fstech.bookmyshow.datamodel;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
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
}
