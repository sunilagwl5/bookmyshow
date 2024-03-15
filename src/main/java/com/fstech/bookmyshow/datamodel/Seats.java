package com.fstech.bookmyshow.datamodel;

import com.fstech.bookmyshow.datamodel.enums.SeatCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seats {
    int seatNo;
    SeatCategory seatCategory;
}
