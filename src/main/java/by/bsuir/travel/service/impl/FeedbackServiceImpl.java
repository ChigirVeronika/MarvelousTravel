package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.FeedbackDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlFeedbackDao;
import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("feedbackService")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    public FeedbackServiceImpl() {
    }

    public FeedbackServiceImpl(MysqlFeedbackDao dao) {
        this.feedbackDao = dao;
    }

    public List<Feedback> findAll() {
        //TODO add to statistics MAY BE!
        return feedbackDao.readAll();
    }

    @Override
    public List<Feedback> findAllForUser(User user) {
        return feedbackDao.readAllForUser(user);
    }

    @Override
    public List<Feedback> findAllForMark(Integer mark) {
        return feedbackDao.readAllForMark(mark);
    }

    @Override
    public List<Feedback> findAllForMarksInRange(Integer lowerLimit, Integer upperLimit) {
        return feedbackDao.readAllForMarksInRange(lowerLimit, upperLimit);
    }

    public void save(Feedback feedback) {
        Feedback f = feedbackDao.read(feedback.getId());
        if (f == null) {
            feedbackDao.create(feedback);
        } else {
            feedbackDao.update(feedback);
        }

    }

    @Override
    public Feedback find(Integer id) {
        return feedbackDao.read(id);
    }

    @Override
    public void delete(Integer id) {
        feedbackDao.delete(id);
    }
}
