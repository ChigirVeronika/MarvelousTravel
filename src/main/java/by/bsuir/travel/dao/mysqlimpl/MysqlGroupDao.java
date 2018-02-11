package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.GroupDao;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("groupDao")
public class MysqlGroupDao extends AbstractDao<Integer, Group> implements GroupDao {

    public void create(Group group) {
        persist(group);
    }

    public Group read(Integer id) {
        return getByKey(id);
    }

    public void update(Group group) {
        updateEntity(group);
    }

    public void delete(Integer id) {
        Group group = getByKey(id);
        delete(group);
    }

    public List<Group> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        List<Group> groups = new ArrayList<>();
//        try{
//            groups = criteria.list();
//        } catch (Exception e){}
        List<Group> groups = criteria.list();
        return groups;
    }

    public Group readForUser(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("user", user));
        return (Group) criteria.uniqueResult();
    }
}
