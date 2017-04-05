package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Feedback;

import java.util.List;

public interface FeedbackDao {
    void create(Feedback feedback);

    List<Feedback> readAll();
}
