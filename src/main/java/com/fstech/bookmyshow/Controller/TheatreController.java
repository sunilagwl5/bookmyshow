package com.fstech.bookmyshow.Controller;


import com.fstech.bookmyshow.datamodel.City;
import com.fstech.bookmyshow.datamodel.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheatreController {
    HashMap<City, List<Theatre>> theatres;
    List<Theatre> allTheatres;

    public TheatreController() {
        theatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public HashMap<City, List<Theatre>> getTheatres() {
        return theatres;
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public void setAllTheatres(List<Theatre> allTheatres) {
        this.allTheatres = allTheatres;
    }
}
