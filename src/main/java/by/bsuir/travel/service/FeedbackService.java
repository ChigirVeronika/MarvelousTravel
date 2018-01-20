package by.bsuir.travel.service;


import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface FeedbackService {

    void save(Feedback feedback);//create or update

    Feedback find(Integer id);

    void delete(Integer id);

    List<Feedback> findAll();

    List<Feedback> findAllForUser(User user);

    List<Feedback> findAllForMark(Integer mark);

    List<Feedback> findAllForMarksInRange(Integer lowerLimit, Integer upperLimit);
}
