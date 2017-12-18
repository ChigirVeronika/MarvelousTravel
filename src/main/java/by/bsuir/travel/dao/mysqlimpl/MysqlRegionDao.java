package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.RegionDao;
import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("regionDao")
public class MysqlRegionDao extends AbstractDao<Integer, Region> implements RegionDao {
    public void create(Region region) {
        persist(region);
    }

    public Region read(Integer id) {
        return getByKey(id);
    }

    public void update(Region region) {
        updateEntity(region);
    }

    public void delete(Integer id) {
        Region region = getByKey(id);
        delete(region);
    }

    public List<Region> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Region> regions = (List<Region>) criteria.list();
        return regions;
    }

    public Region readForCountry(Country country) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("country", country));
        Region region = (Region) criteria.uniqueResult();
        return region;
    }
}
