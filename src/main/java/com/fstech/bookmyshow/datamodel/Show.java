package com.fstech.bookmyshow.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Show {
    int id;
    Movie movie;
    String startTime;
    Screen screen;
    List<Integer> bookedSeats;
    int duration;
}
