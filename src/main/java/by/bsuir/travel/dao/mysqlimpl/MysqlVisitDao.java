package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.VisitDao;
import by.bsuir.travel.entity.Visit;

public class MysqlVisitDao extends AbstractDao<Integer, Visit> implements VisitDao {
    @Override
    public void save(Visit visit) {
        persist(visit);
    }
}