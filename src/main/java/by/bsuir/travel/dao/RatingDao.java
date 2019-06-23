package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Rating;

import java.util.List;

public interface RatingDao {
    List<Rating> readAll();

    void create(Rating rating);
}
