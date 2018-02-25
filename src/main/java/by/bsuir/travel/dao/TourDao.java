package by.bsuir.travel.dao;

import by.bsuir.travel.entity.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface TourDao {

    void create(Tour tour);

    Tour read(Integer id);

    void update(Tour tour);

    void delete(Integer id);

    List<Tour> readAll();
    List<Tour> readAllForGroup(Group group);

    List<Tour> readAllForCitiesAndDates(Tour tour);

    List<Tour> readAllForTravel(City from, City to);

    List<Tour> readAllForTravel(City cityFrom, List<City> listTo,
                                Date dateFrom, Double priceTopLimit);

    List<Tour> readAllForTravel(City from, City to, Timestamp date);

    List<Tour> readAllForTravel(City from, City to, Timestamp date, Double price);

    List<Tour> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double price);

    List<Tour> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double priceLo, Double priceHi);

}
