package by.bsuir.travel.service;


import by.bsuir.travel.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> findAll();

    void save(Feedback feedback);
}
