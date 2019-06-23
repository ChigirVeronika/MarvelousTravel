package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.PlaceDao;
import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Tag;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("placeDao")
public class MysqlPlaceDao extends AbstractDao<Integer, Place> implements PlaceDao {

    @Override
    public List<Place> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Place> places = criteria.list();
        return places;
    }

    @Override
    public Place read(Integer id) {
        return getByKey(id);
    }

    @Override
    public Place read(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("name", name));
        Place place = (Place) criteria.uniqueResult();
        return place;
    }

    @Override
    public void create(Place place) {
        persist(place);
    }

    @Override
    public List<Place> readByTags(Tag one, Tag two) {
        Criteria criteria = createEntityCriteria();
        criteria.createAlias("tags", "tagsAlias");
        criteria.add(Restrictions.eq("tagsAlias.name", one.getName()));
        criteria.add(Restrictions.eq("tagsAlias.name", two.getName()));
        List<Place> places = criteria.list();
        return places;
    }

    @Override
    public List<Place> readByTag(Tag one) {
        Criteria criteria = createEntityCriteria();
        criteria.createAlias("tags", "tagsAlias");
        criteria.add(Restrictions.eq("tagsAlias.name", one.getName()));
        List<Place> places = criteria.list();
        return places;
    }

    @Override
    public List<Place> readLike(String name) {
        Criteria criteria = createEntityCriteria();

        Disjunction or = Restrictions.disjunction();
        or.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
        or.add(Restrictions.like("about", name, MatchMode.ANYWHERE));
        criteria.add(or);

        List<Place> places = criteria.list();

        return places;
    }
}
