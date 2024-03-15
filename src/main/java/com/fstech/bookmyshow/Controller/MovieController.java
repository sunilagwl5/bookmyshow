package com.fstech.bookmyshow.Controller;


import com.fstech.bookmyshow.datamodel.City;
import com.fstech.bookmyshow.datamodel.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MovieController {
    HashMap<City, List<Movie>> movies;
    List<Movie> allMovies;

    public MovieController() {
        movies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public HashMap<City, List<Movie>> getMovies() {
        return movies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }
}
