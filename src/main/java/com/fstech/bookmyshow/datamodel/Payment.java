package com.fstech.bookmyshow.datamodel;

import lombok.Data;

import java.util.UUID;

@Data
public class Payment {
    int id;
    boolean paymentSuccessful;

    public Payment(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
        this.id = UUID.randomUUID().hashCode();
    }

}
