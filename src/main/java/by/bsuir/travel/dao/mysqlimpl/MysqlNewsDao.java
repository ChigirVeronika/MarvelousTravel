package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.NewsDao;
import by.bsuir.travel.entity.News;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Repository("newsDao")
public class MysqlNewsDao extends AbstractDao<Integer, News> implements NewsDao {

    private static final String PERCENT = "%";

    public void create(News news) {
        persist(news);
    }

    public News read(Integer id) {
        return getByKey(id);
    }

    public List<News> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<News> news = criteria.list();
        return news;
    }

    public List<News> readAllForName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.like("name", PERCENT + name + PERCENT));//todo check
        List<News> news = criteria.list();
        System.out.println(news.size());
        return news;
    }

    public List<News> readAllForDate(Timestamp date) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("date", date));
        List<News> news = criteria.list();
        return news;
    }

    public List<News> readAllForDatesInRange(Timestamp lowerLimit, Timestamp upperLimit) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<News> news = criteria.list();
        criteria.add(Restrictions.between("date", lowerLimit, upperLimit));
        return news;
    }

    public void update(News news) {
        updateEntity(news);
    }

    public void delete(Integer id) {
        News news = getByKey(id);
        delete(news);
    }

    @Override
    public void delete(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("name", name));
        News news = (News) criteria.uniqueResult();
        delete(news);
    }
}
