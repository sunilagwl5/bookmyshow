package com.bookmyshow;

import java.util.UUID;

public class Movie {
    String name;
    int id;
    int duration;
    String language;

    public Movie(String name, int duration, String language) {
        this.id = UUID.randomUUID().hashCode();
        this.name = name;
        this.duration = duration;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
