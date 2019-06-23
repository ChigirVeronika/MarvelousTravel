package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.RatingDao;
import by.bsuir.travel.entity.Rating;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ratingDao")
public class MysqlRatingDao extends AbstractDao<Integer, Rating> implements RatingDao {

    @Override
    public List<Rating> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Rating> list = criteria.list();
        return list;
    }

    @Override
    public void create(Rating rating) {
        persist(rating);
    }
}
