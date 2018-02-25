package by.bsuir.travel.service;

import by.bsuir.travel.dto.TourDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.Tour;

import java.text.ParseException;
import java.util.List;

public interface TourService {
    Tour find(Integer id);

    List<Tour> findAll();

    List<Tour> findAllForGroup(Group group);

    List<Tour> findAllForCitiesAndDates(Tour tour);

    List<Tour> findAllForTourDtoParams(TourDto dto) throws ParseException;
}
