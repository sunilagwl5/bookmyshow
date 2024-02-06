package com.bookmyshow;

public class Seats {
    int seatNo;
    SeatCategory seatCategory;
    int price;

    public Seats(int seatNo, SeatCategory seatCategory) {
        this.seatNo = seatNo;
        this.seatCategory = seatCategory;
        this.price = seatCategory.getPrice();
    }

    public int getSeatNo() {
        return seatNo;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public int getPrice() {
        return price;
    }
}
