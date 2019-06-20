package by.bsuir.travel.service;

import by.bsuir.travel.entity.Place;

import java.util.List;

public interface PlaceService {

    List<Place> findAll();

    Place find(Integer id);

    Place find(String name);

    void save(Place place);
}
