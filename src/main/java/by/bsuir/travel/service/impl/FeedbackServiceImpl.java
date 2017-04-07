package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.FeedbackDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlFeedbackDao;
import by.bsuir.travel.entity.Feedback;
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

    public FeedbackServiceImpl(){}
    public FeedbackServiceImpl(MysqlFeedbackDao dao){this.feedbackDao = dao;}

    public List<Feedback> findAll() {
        //TODO add to statistics MAY BE!
        return feedbackDao.readAll();
    }

    public void save(Feedback feedback) {
        feedbackDao.create(feedback);
    }
}
