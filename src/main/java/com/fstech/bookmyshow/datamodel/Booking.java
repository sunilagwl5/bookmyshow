package com.fstech.bookmyshow.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Booking {
    Screen screen;
    Show show;
    Payment payment;
    List<Seats> seats;
}
