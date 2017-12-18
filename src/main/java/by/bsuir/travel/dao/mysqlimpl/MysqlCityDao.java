package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.CityDao;
import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Country;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cityDao")
public class MysqlCityDao extends AbstractDao<Integer, City> implements CityDao {

    public void create(City city) {
        persist(city);
    }

    public City read(Integer id) {
        return getByKey(id);
    }

    public void update(City city) {
        updateEntity(city);
    }

    public void delete(Integer id) {
        City city = getByKey(id);
        delete(city);
    }

    public List<City> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<City> cities = criteria.list();
        return cities;
    }

    public List<City> readAllForCountry(Country country) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("country", country));
        List<City> cities = criteria.list();
        return cities;
    }
}
