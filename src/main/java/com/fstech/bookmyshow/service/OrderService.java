package com.fstech.bookmyshow.service;

import com.fstech.bookmyshow.datamodel.Booking;
import com.fstech.bookmyshow.datamodel.Show;

import java.util.List;

public interface OrderService {
    Booking creatBooking(List<String> seatIds, Show show);
}
