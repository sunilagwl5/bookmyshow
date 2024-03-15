package com.fstech.bookmyshow.service;

import com.fstech.bookmyshow.datamodel.Movie;
import com.fstech.bookmyshow.datamodel.Theatre;

import java.util.List;

public interface SearchService {

    List<Movie> findMoviesByCity(String city);

    List<Theatre> findTheatersByCity(String city);
}
