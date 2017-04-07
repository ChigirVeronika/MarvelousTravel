package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.FeedbackDao;
import by.bsuir.travel.entity.Feedback;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("feedbackDao")
public class MysqlFeedbackDao extends AbstractDao<Integer, Feedback> implements FeedbackDao{
    public void create(Feedback feedback) {
        persist(feedback);
    }

    public List<Feedback> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Feedback> feedbacks = criteria.list();
        return feedbacks;
    }
}
