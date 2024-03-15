package com.fstech.bookmyshow.service.impl;

import com.fstech.bookmyshow.datamodel.Show;
import com.fstech.bookmyshow.datamodel.Theatre;
import com.fstech.bookmyshow.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("product")
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Show> findShowsByTheaterId(int theatreId, String movie) {
//        Theatre choosenTheatre = LocalDB.theatresByCity.values()
//                .stream()
//                .filter(theatre -> theatre.getId() == theatreId)
//                .findFirst()
//                .orElse(null);
//

        return null;
    }

    @Override
    public List<Show> findShowsByTheater(Theatre choosenTheatre, String movie) {
        for (int i = 0; i < choosenTheatre.getShows().size(); i++) {
            if (choosenTheatre.getShows().get(i).getMovie().getName().equals(movie)) {
                System.out.println("StartTime : " + choosenTheatre.getShows().get(i).getStartTime() + " Id : " + choosenTheatre.getShows().get(i).getId());
            }
        }
        return choosenTheatre.getShows();
    }

    @Override
    public Show getShowByShowId(int showId) {
//        Show show = choosenTheatre.getShows()
//                .stream()
//                .filter(show1 -> show1.getId() == showId)
//                .findFirst()
//                .orElse(null);

        System.out.println("Select seat no.");
//        return show;
        return null;
    }
}
