package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.NewsDao;
import by.bsuir.travel.entity.News;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Repository("newsDao")
public class MysqlNewsDao extends AbstractDao<Integer, News> implements NewsDao {


    public void create(News news) {
        persist(news);
    }

    public News read(Integer id) {
        return null;
    }

    public List<News> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<News> news = (List<News>)criteria.list();
        return news;
    }

    public List<News> readAllForName(String name)
    {
        return null;
    }

    public List<News> readAllForDate(Timestamp date)
    {
        return null;
    }

    public List<News> readAllForDatesInRange(Timestamp lowerLimit, Timestamp upperLimit)
    {
        return null;
    }

    public void update(News news) {

    }

    public void delete(Integer id) {

    }
}
