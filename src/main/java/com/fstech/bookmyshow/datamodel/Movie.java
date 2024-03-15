package com.fstech.bookmyshow.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
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
}
