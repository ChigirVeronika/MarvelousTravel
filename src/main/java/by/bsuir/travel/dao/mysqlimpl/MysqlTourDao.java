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
    public List<Tour> readAllForCitiesAndDates(Tour tour) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("cityFrom", tour.getCityFrom()));
        criteria.add(Restrictions.eq("cityTo", tour.getCityTo()));
        criteria.add(Restrictions.eq("startDate", tour.getStartDate()));
        criteria.add(Restrictions.eq("endDate", tour.getEndDate()));
        criteria.add(Restrictions.between("price",
                new Double(0.00), tour.getPrice() + new Double(100.00)));
        List<Tour> tours = criteria.list();
        return tours;
    }

    public List<Ticket> readAllForTravel(City from, City to)
    {
        return null;
    }

    public List<Ticket> readAllForTravel(City from, City to, Timestamp date)
    {
        return null;
    }

    public List<Ticket> readAllForTravel(City from, City to, Timestamp date, Double price)
    {
        return null;
    }

    public List<Ticket> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double price)
    {
        return null;
    }

    public List<Ticket> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double priceFrom, Double priceTo)
    {
        return null;
    }
}
