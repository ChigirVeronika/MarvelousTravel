package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface FeedbackDao {

    void create(Feedback feedback);

    Feedback read(Integer id);

    void update(Feedback feedback);

    void delete(Integer id);

    List<Feedback> readAll();

    List<Feedback> readAllForUser(User user);

    List<Feedback> readAllForMark(Integer mark);

    List<Feedback> readAllForMarksInRange(Integer lowerLimit, Integer upperLimit);
}
