package com.bookmyshow;

import java.util.List;

public class Booking {
    Screen screen;
    Show show;
    Payment payment;
    List<Seats> seats;

    public Booking(Screen screen, Show show, Payment payment, List<Seats> seats) {
        this.screen = screen;
        this.show = show;
        this.payment = payment;
        this.seats = seats;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }
}
