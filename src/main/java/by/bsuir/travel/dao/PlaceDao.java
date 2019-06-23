package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Tag;

import java.util.List;

public interface PlaceDao {
    List<Place> readAll();

    Place read(Integer id);

    Place read(String name);

    void create(Place place);

    List<Place> readByTags(Tag one, Tag two);

    List<Place> readByTag(Tag one);

    List<Place> readLike(String name);
}
