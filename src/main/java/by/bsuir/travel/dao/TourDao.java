package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Tour;

import java.util.List;

public interface TourDao {
    List<Tour> readAllForCitiesAndDates(Tour tour);
}
