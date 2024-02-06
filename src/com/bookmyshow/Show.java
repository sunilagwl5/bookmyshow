package com.bookmyshow;

import java.util.List;

public class Show {
    int id;
    Movie movie;
    String startTime;
    Screen screen;
    List<Integer> bookedSeats;
    int duration;

    public Show(int id, Movie movie, String startTime, Screen screen, List<Integer> bookedSeats, int duration) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
        this.screen = screen;
        this.bookedSeats = bookedSeats;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void addBookedSeats(int seatNo) {
        this.bookedSeats.add(seatNo);
    }

    public void removeBookedSeats(int seatNo) {
        this.bookedSeats.remove(seatNo);
    }
}
