package com.fstech.bookmyshow;

import com.fstech.bookmyshow.datamodel.Booking;
import com.fstech.bookmyshow.datamodel.Movie;
import com.fstech.bookmyshow.datamodel.Show;
import com.fstech.bookmyshow.datamodel.Theatre;
import com.fstech.bookmyshow.service.OrderService;
import com.fstech.bookmyshow.service.PaymentService;
import com.fstech.bookmyshow.service.ProductService;
import com.fstech.bookmyshow.service.SearchService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class BookMyShowInitializer {

    @Autowired
    SearchService searchService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    PaymentService paymentService;

    @PostConstruct
    public void start() {
        System.out.println("Hello ! Enter your City");
        String city = "Bangalore";
        List<Movie> movies = searchService.findMoviesByCity(city);

        System.out.println("Enter the movie you want to book");
        String movie = "JAWAN";
        List<Theatre> theatres = searchService.findTheatersByCity(city);

        System.out.println("Enter the theatre ID  you want to book");
//        int theatreId = theatres.get(0).getId();
        List<Show> shows = productService.findShowsByTheater(theatres.get(0), movie);

        System.out.println("Select show Id");
//        int showId = shows.get(0).getId();
//        Show show = productService.getShowsById(showId);
        Show show =  shows.get(0);

        Integer seatNo = 1;
        Booking booking = orderService.creatBooking(Arrays.asList(new String[] {seatNo+""}), show);
        Boolean payment = paymentService.makePayment(Boolean.TRUE);

        if (payment) {
            System.out.println("Yay Booking done");
            System.out.println("Alloted Screen : " + booking.getScreen().getScreenNo());
            System.out.println("Alloted Seat No." + booking.getScreen().getSeats().get(0).getSeatNo());
            System.out.println("Start Time is : " + booking.getShow().getStartTime() + " PM");
            System.out.println("Movie : " + booking.getShow().getMovie().getName());
            System.out.println("Payment Done :" + booking.getPayment().isPaymentSuccessful());
        } else {
            show.setBookedSeats(Arrays.asList(new Integer[]{seatNo}));
            System.out.println("Oops Booking Failed");
        }
    }
}