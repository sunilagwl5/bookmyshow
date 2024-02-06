package com.bookmyshow;

import java.util.UUID;

public class Payment {
    int id;
    boolean paymentSuccessful;

    public Payment(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
        this.id = UUID.randomUUID().hashCode();
    }

    public int getId() {
        return id;
    }

    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    public void setPaymentSuccessful(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
    }
}
