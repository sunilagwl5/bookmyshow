package com.fstech.bookmyshow.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Screen {
    int screenNo;
    List<Seats> seats;

}
