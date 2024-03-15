package com.fstech.bookmyshow.datamodel.enums;

public enum SeatCategory {
    GOLD(120), PLATINUM(150), DIAMOND(180);
    private int price;

    SeatCategory(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
