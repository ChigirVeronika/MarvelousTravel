package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.TagDao;
import by.bsuir.travel.entity.Tag;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tagDao")
public class MysqlTagDao extends AbstractDao<Integer, Tag> implements TagDao {

    @Override
    public List<Tag> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Tag> list = criteria.list();
        return list;
    }

    @Override
    public Tag read(Integer id) {
        return getByKey(id);
    }

    @Override
    public Tag read(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("name", name));
        Tag tag = (Tag) criteria.uniqueResult();
        return tag;
    }
}
