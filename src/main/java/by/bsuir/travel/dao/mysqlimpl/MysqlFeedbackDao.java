package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.FeedbackDao;
import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("feedbackDao")
public class MysqlFeedbackDao extends AbstractDao<Integer, Feedback> implements FeedbackDao {
    public void create(Feedback feedback) {
        persist(feedback);
    }

    public Feedback read(Integer id) {
        return getByKey(id);
    }

    public void update(Feedback feedback) {
        updateEntity(feedback);
    }

    public void delete(Integer id) {
        Feedback feedback = getByKey(id);
        delete(feedback);
    }

    public List<Feedback> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Feedback> feedbacks = criteria.list();
        return feedbacks;
    }

    public List<Feedback> readAllForUser(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("user", user));
        List<Feedback> feedbacks = criteria.list();
        return feedbacks;
    }

    public List<Feedback> readAllForMark(Integer mark) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("mark", mark));
        List<Feedback> feedbacks = criteria.list();
        return feedbacks;
    }

    public List<Feedback> readAllForMarksInRange(Integer lowerLimit, Integer upperLimit) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.between("mark", lowerLimit, upperLimit));
        List<Feedback> feedbacks = criteria.list();
        return feedbacks;
    }
}
