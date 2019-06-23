package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.StatisticDao;
import by.bsuir.travel.entity.Statistic;
import org.hibernate.Criteria;

import java.util.List;

public class MysqlStatisticDao extends AbstractDao<Integer, Statistic> implements StatisticDao {

    @Override
    public List<Statistic> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Statistic> statistics = criteria.list();
        return statistics;
    }
}
