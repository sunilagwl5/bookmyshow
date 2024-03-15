package com.fstech.bookmyshow.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class City {
    int id;
    String name;
    String state;

    public City(String name, String state) {
        this.name = name;
        this.id = UUID.randomUUID().hashCode();
        this.state = state;
    }
}
