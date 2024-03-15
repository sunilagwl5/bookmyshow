package com.fstech.bookmyshow.service.impl;

import com.fstech.bookmyshow.datamodel.Booking;
import com.fstech.bookmyshow.datamodel.Payment;
import com.fstech.bookmyshow.datamodel.Seats;
import com.fstech.bookmyshow.datamodel.Show;
import com.fstech.bookmyshow.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("order")
public class OrderServiceImpl implements OrderService {

    @Override
    public Booking creatBooking(List<String> seatIds, Show show) {
        Integer seatNo = Integer.parseInt(seatIds.get(0));
        while (seatNo == null) {
//            Scanner sc4 = new Scanner(System.in);
//            seatNo = sc4.nextInt();
            seatNo = 4;
            assert show != null;
            if (show.getBookedSeats().contains(seatNo)) {
                System.out.println("OOPS this seat is occupied now, please choose another");
                seatNo = null;
            }
        }
        show.setBookedSeats(Arrays.asList(new Integer[]{seatNo}));
        Integer finalSeatNo = seatNo;
        Seats seat = show.getScreen().getSeats().stream().filter(seats -> seats.getSeatNo() == finalSeatNo).findFirst().orElse(null);
        System.out.println("Did Payment True / False");
//        Scanner sc5 = new Scanner(System.in);
//        boolean payment = sc5.nextBoolean();
        boolean payment = Boolean.TRUE;

        Booking booking = new Booking(show.getScreen(), show, new Payment(payment), Collections.singletonList(seat));
        return  booking;
    }
}
