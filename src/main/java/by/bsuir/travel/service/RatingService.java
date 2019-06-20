package by.bsuir.travel.service;

import by.bsuir.travel.entity.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> findAll();

    void save(Rating rating);
}
