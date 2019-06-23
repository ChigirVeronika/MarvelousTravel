package by.bsuir.travel.service;

import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Tag;

import java.util.List;

public interface PlaceService {

    List<Place> findAll();

    Place find(Integer id);

    Place find(String name);
    List<Place> findLike(String name);

    void save(Place place);

    Place findRandomByTags(Tag one, Tag two);
    Place findRandomByTag(Tag one);
}
