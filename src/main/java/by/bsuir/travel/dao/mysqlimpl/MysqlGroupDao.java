package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.GroupDao;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupDao")
public class MysqlGroupDao extends AbstractDao<Integer, Group> implements GroupDao {
    public List<Group> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Group> groups = criteria.list();
        return groups;
    }

    public Group readForUser(User user)
    {
        return null;
    }

    public Group read(Integer id) {
        Group group = getByKey(id);
        return group;
    }

    public void create(Group group) {
        persist(group);
    }

    public void update(Group group) {
        updateEntity(group);
    }

    public void delete(Group group) {
        delete(group);
    }
}
