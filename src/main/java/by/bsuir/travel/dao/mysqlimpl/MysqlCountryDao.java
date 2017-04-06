package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.CountryDao;
import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDao")
public class MysqlCountryDao extends AbstractDao<Integer, Country> implements CountryDao {
    public void create(Country country) {

    }

    public Country read(Integer id) {
        return getByKey(id);
    }

    public void update(Country country) {

    }

    public void delete(Integer id) {

    }

    public List<Country> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Country> countries = criteria.list();
        return countries;
    }

    public List<Country> readAllForRegion(Region region) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("region", region));
        List<Country> countries = criteria.list();
        return countries;
    }
}
