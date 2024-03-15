package com.fstech.bookmyshow.service;

import com.fstech.bookmyshow.datamodel.Show;
import com.fstech.bookmyshow.datamodel.Theatre;

import java.util.List;

public interface ProductService {
    List<Show> findShowsByTheaterId(int theatreId, String movie);
    List<Show> findShowsByTheater(Theatre theatre, String movie);

    Show getShowByShowId(int showId);
}
