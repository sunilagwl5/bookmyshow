package com.bookmyshow;

import java.util.List;

public class Screen {
    int screenNo;
    List<Seats> seats;

    public Screen(int screenNo, List<Seats> seats) {
        this.screenNo = screenNo;
        this.seats = seats;
    }

    public int getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(int screenNo) {
        this.screenNo = screenNo;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }
}
