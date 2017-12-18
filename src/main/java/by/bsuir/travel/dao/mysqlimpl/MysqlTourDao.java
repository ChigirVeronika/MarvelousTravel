package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.TourDao;
import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Ticket;
import by.bsuir.travel.entity.Tour;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("tourDao")
public class MysqlTourDao extends AbstractDao<Integer, Tour> implements TourDao {

    public void create(Tour tour) {
        persist(tour);
    }

    public Tour read(Integer id) {
        return getByKey(id);
    }

    public void update(Tour tour) {
        updateEntity(tour);
    }

    public void delete(Integer id) {
        Tour tour = getByKey(id);
        delete(tour);
    }

    public List<Tour> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Tour> tours = criteria.list();
        return tours;
    }

    public List<Tour> readAllForCitiesAndDates(Tour tour) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("cityFrom", tour.getCityFrom()));
        criteria.add(Restrictions.eq("cityTo", tour.getCityTo()));
        criteria.add(Restrictions.eq("startDate", tour.getStartDate()));
        criteria.add(Restrictions.eq("endDate", tour.getEndDate()));
        criteria.add(Restrictions.le("price", tour.getPrice()));
        List<Tour> tours = criteria.list();
        return tours;
    }

    public List<Tour> readAllForTravel(City from, City to) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("cityFrom", from));
        criteria.add(Restrictions.eq("cityTo", to));
        List<Tour> tours = criteria.list();
        return tours;
    }

    public List<Tour> readAllForTravel(City from, City to, Timestamp date) {
        throw new UnsupportedOperationException
                ("No implementation for method MysqlDao.readAllForTravel(City from, City to, Timestamp date).");
    }

    public List<Tour> readAllForTravel(City from, City to, Timestamp date, Double price) {
        throw new UnsupportedOperationException
                ("No implementation for method MysqlDao.readAllForTravel(City from, City to, Timestamp date, Double price).");
    }

    public List<Tour> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double price) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("cityFrom", from));
        criteria.add(Restrictions.eq("cityTo", to));
        criteria.add(Restrictions.eq("startDate", dateFrom));
        criteria.add(Restrictions.eq("endDate", dateTo));
        criteria.add(Restrictions.le("price", price));
        List<Tour> tours = criteria.list();
        return tours;
    }

    public List<Tour> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double priceLo, Double priceHi) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("cityFrom", from));
        criteria.add(Restrictions.eq("cityTo", to));
        criteria.add(Restrictions.eq("startDate", dateFrom));
        criteria.add(Restrictions.eq("endDate", dateTo));
        criteria.add(Restrictions.between("price", priceLo, priceHi));
        List<Tour> tours = criteria.list();
        return tours;
    }
}
