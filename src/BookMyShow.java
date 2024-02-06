import Controller.MovieController;
import Controller.TheatreController;
import com.bookmyshow.*;

import java.util.*;

public class BookMyShow {
    private final MovieController movieController;
    private final TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.preProcessing();
        System.out.println("Hello Bro ! Enter your City");
        Scanner sc = new Scanner(System.in);
        String city = sc.next();

        List<Movie> movies = new ArrayList<>();
        for (Map.Entry<City, List<Movie>> mp : bookMyShow.movieController.getMovies().entrySet()) {
            if (city.equals(mp.getKey().getName())) {
                movies = mp.getValue();
            }
        }

        System.out.println("Currently Running Movies are ");
        for (Movie movie : movies) {
            System.out.println("NAME : " + movie.getName() + " Duration : " + movie.getDuration() + " Language : " + movie.getLanguage());
        }

        System.out.println("Enter the movie you want to book");
        Scanner sc2 = new Scanner(System.in);
        String movie = sc2.next();

        List<Theatre> theatres = new ArrayList<>();
        for (Map.Entry<City, List<Theatre>> mp : bookMyShow.theatreController.getTheatres().entrySet()) {
            if (city.equals(mp.getKey().getName())) {
                theatres = mp.getValue();
            }
        }

        for (Theatre theatre : theatres) {
            System.out.println("city: " + theatre.getCity().getName() + " address: " + theatre.getAddress() + " id : " + theatre.getId());
        }

        System.out.println("Enter the theatre ID  you want to book");

        Scanner sc3 = new Scanner(System.in);
        int theatreId = sc3.nextInt();

        Theatre choosenTheatre = theatres
                                .stream()
                                .filter(theatre -> theatre.getId() == theatreId)
                                .findFirst()
                                .orElse(null);

        for(int i = 0; i < choosenTheatre.getShows().size(); i++) {
            if (choosenTheatre.getShows().get(i).getMovie().getName().equals(movie)) {
                System.out.println("StartTime : " + choosenTheatre.getShows().get(i).getStartTime() + " Id : " + choosenTheatre.getShows().get(i).getId());
            }
        }

        System.out.println("Select show Id");
        Scanner sc6 = new Scanner(System.in);
        int showId = sc6.nextInt();
        Show show = choosenTheatre.getShows()
                                .stream()
                                .filter(show1 -> show1.getId() == showId)
                                .findFirst()
                                .orElse(null);

        System.out.println("Select seat no.");
        Integer seatNo = null;

        while(seatNo == null) {
            Scanner sc4 = new Scanner(System.in);
            seatNo = sc4.nextInt();
            assert show != null;
            if (show.getBookedSeats().contains(seatNo)) {
                System.out.println("OOPS this seat is occupied now, please choose another");
                seatNo = null;
            }
        }
        show.addBookedSeats(seatNo);
        Integer finalSeatNo = seatNo;
        Seats seat = show.getScreen().getSeats().stream().filter(seats -> seats.getSeatNo() == finalSeatNo).findFirst().orElse(null);
        System.out.println("Did Payment True / False");
        Scanner sc5 = new Scanner(System.in);
        boolean payment = sc5.nextBoolean();

        Booking booking = new Booking(show.getScreen(), show, new Payment(payment), Collections.singletonList(seat));
        if (payment) {
            System.out.println("Yay Booking done");
            System.out.println("Alloted Screen : " + booking.getScreen().getScreenNo());
            System.out.println("Alloted Seat No." + booking.getScreen().getSeats().get(0));
            System.out.println("Start Time is : " + booking.getShow().getStartTime() + " PM");
            System.out.println("Movie : " + booking.getShow().getMovie().getName());
            System.out.println("Payment Done :" + booking.getPayment().isPaymentSuccessful());
        } else {
            show.removeBookedSeats(seatNo);
            System.out.println("Oops Booking Failed");
        }
    }

    private void preProcessing() {
        createTheatre();
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Bangalore", "Karnataka"));
        cities.add(new City("Mumbai", "Maharashtra"));
        return cities;
    }

    private static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("PATHAAN", 3, "HINDI"));
        movies.add(new Movie("JAWAN", 3, "HINDI"));
        movies.add(new Movie("DUNKI", 3, "HINDI"));
        return movies;
    }
    private void createTheatre() {
        List<City> cities = getCities();
        List<Movie> movies = getMovies();

        List<Movie> moviesBangalore = new ArrayList<>(movies);
        List<Movie> moviesMumbai = new ArrayList<>(movies);

        movieController.setAllMovies(movies);
        movieController.getMovies().put(cities.get(0), moviesBangalore);
        movieController.getMovies().put(cities.get(1), moviesMumbai);

        List<Theatre> theatres = new ArrayList<>();

        theatres.add(new Theatre(cities.get(0), "Kormangala", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(0), "Marathahalli", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(0), "Kadubeshanhalli", createScreen(), createShow(movies)));

        theatres.add(new Theatre(cities.get(1), "SRK Mannat", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(1), "SK Galaxy", createScreen(), createShow(movies)));
        theatres.add(new Theatre(cities.get(1), "Marine Drive", createScreen(), createShow(movies)));

        theatreController.setAllTheatres(theatres);
        theatreController.getTheatres().put(cities.get(0), theatres.subList(0, 2));
        theatreController.getTheatres().put(cities.get(1), theatres.subList(3, 5));
    }

    private List<Seats> createSeats() {
        List<Seats> seats = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            Seats seat = null;
            if(i <= 30) {
                seat = new Seats(i, SeatCategory.GOLD);
            } else if (i <= 70) {
                seat = new Seats(i, SeatCategory.PLATINUM);
            } else {
                seat = new Seats(i, SeatCategory.DIAMOND);
            }
            seats.add(seat);
        }
        return seats;
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            screens.add(new Screen(i, createSeats()));
        }
        return screens;
    }

    private List<Show> createShow(List<Movie> movies) {
        List<Show> shows = new ArrayList<>();
        List<Screen> screens = createScreen();
        List<Integer> bookedSeats = new ArrayList<>();
        bookedSeats.add(1);
        bookedSeats.add(2);
        for(int i = 1; i <= 6; i++) {
            Show show = new Show(i, movies.get(i % 2), String.valueOf(i), screens.get(i), bookedSeats, 3);
            shows.add(show);
        }
        return shows;
    }
}