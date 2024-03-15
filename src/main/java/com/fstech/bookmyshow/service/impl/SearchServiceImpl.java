package com.fstech.bookmyshow.service.impl;

import com.fstech.bookmyshow.datamodel.City;
import com.fstech.bookmyshow.datamodel.Movie;
import com.fstech.bookmyshow.datamodel.Theatre;
import com.fstech.bookmyshow.db.LocalDB;
import com.fstech.bookmyshow.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("search")
public class SearchServiceImpl implements SearchService {

    @Override
    public List<Movie> findMoviesByCity(String city) {
        List<Movie> movies = new ArrayList<>();
        for (Map.Entry<City, List<Movie>> mp : LocalDB.moviesByCity.entrySet() ) {
            if (city.equals(mp.getKey().getName())) {
                movies = mp.getValue();
            }
        }

        System.out.println("Currently Running Movies are ");
        for (Movie movie : movies) {
            System.out.println("NAME : " + movie.getName() + " Duration : " + movie.getDuration() + " Language : " + movie.getLanguage());
        }

        return  movies;
    }

    @Override
    public List<Theatre> findTheatersByCity(String city) {

        List<Theatre> theatres = new ArrayList<>();
        for (Map.Entry<City, List<Theatre>> mp : LocalDB.theatresByCity.entrySet()) {
            if (city.equals(mp.getKey().getName())) {
                theatres = mp.getValue();
            }
        }

        for (Theatre theatre : theatres) {
            System.out.println("city: " + theatre.getCity().getName() + " address: " + theatre.getAddress() + " id : " + theatre.getId());
        }
        return  theatres;
    }

}
