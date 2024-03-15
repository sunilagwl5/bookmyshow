package com.fstech.bookmyshow.db;

import com.fstech.bookmyshow.datamodel.*;
import com.fstech.bookmyshow.datamodel.enums.SeatCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("LocalDB")
public class LocalDB {
    public static HashMap<City, List<Movie>>  moviesByCity =  new HashMap<>();
    public static HashMap<City, List<Theatre>> theatresByCity  =  new HashMap<>();


    static {
        createTheatre();
    }
    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Bangalore", "Karnataka"));
        cities.add(new City("Mumbai", "Maharashtra"));
        return cities;
    }

    private static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("PATHAAN", 3, "HINDI"));
        movies.add(new Movie("JAWAN", 3, "HINDI"));
        movies.add(new Movie("DUNKI", 3, "HINDI"));
        return movies;
    }


    private static void createTheatre() {
        List<City> cities = getCities();
        List<Movie> movies = getMovies();

        List<Movie> moviesBangalore = new ArrayList<>(movies);
        List<Movie> moviesMumbai = new ArrayList<>(movies);

        moviesByCity.put(cities.get(0), moviesBangalore);
        moviesByCity.put(cities.get(1), moviesMumbai);

        List<Theatre> theatres = new ArrayList<>();

        theatres.add(new Theatre(cities.get(0), "Kormangala", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(0), "Marathahalli", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(0), "Kadubeshanhalli", createScreen(), createShow(movies)));

        theatres.add(new Theatre(cities.get(1), "SRK Mannat", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(1), "SK Galaxy", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(1), "Marine Drive", createScreen(), createShow(movies)));

        theatresByCity.put(cities.get(0), theatres.subList(0, 2));
        theatresByCity.put(cities.get(1), theatres.subList(3, 5));
    }

    private static List<Seats> createSeats() {
        List<Seats> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Seats seat = null;
            if (i <= 30) {
                seat = new Seats(i, SeatCategory.GOLD);
            } else if (i <= 70) {
                seat = new Seats(i, SeatCategory.PLATINUM);
            } else {
                seat = new Seats(i, SeatCategory.DIAMOND);
            }
            seats.add(seat);
        }
        return seats;
    }

    private static List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            screens.add(new Screen(i, createSeats()));
        }
        return screens;
    }

    private static List<Show> createShow(List<Movie> movies) {
        List<Show> shows = new ArrayList<>();
        List<Screen> screens = createScreen();
        List<Integer> bookedSeats = new ArrayList<>();
        bookedSeats.add(1);
        bookedSeats.add(2);
        for (int i = 1; i <= 6; i++) {
            Show show = new Show(i, movies.get(i % 2), String.valueOf(i), screens.get(i), bookedSeats, 3);
            shows.add(show);
        }
        return shows;
    }
}
