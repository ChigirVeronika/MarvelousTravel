package by.bsuir.travel.service;

import by.bsuir.travel.entity.Tour;

import java.util.List;

public interface TourService {
    Tour find(Integer id);

    List<Tour> findAll();

    List<Tour> findAllForCitiesAndDates(Tour tour);
}
