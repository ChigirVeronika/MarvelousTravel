package by.bsuir.travel.dao;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Ticket;
import by.bsuir.travel.entity.Tour;

import java.sql.Timestamp;
import java.util.List;

public interface TourDao {
    List<Tour> readAllForCitiesAndDates(Tour tour);

    List<Ticket> readAllForTravel(City from, City to);

    List<Ticket> readAllForTravel(City from, City to, Timestamp date);

    List<Ticket> readAllForTravel(City from, City to, Timestamp date, Double price);

    List<Ticket> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo,Double price);

    List<Ticket> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double priceFrom, Double priceTo);

}
