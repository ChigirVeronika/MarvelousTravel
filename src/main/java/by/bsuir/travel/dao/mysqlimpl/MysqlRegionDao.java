package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.RegionDao;
import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("regionDao")
public class MysqlRegionDao extends AbstractDao<Integer, Region> implements RegionDao{
    public void create(Region region) {

    }

    public Region read(Integer id) {
        return null;
    }

    public void update(Region region) {

    }

    public void delete(Integer id) {

    }

    public List<Region> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Region> regions = (List<Region>)criteria.list();
        return regions;
    }

    public Region readForCountry(Country country)
    {
        return null;
    }
}
