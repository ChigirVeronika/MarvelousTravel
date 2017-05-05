package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.UserDao;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class MysqlUserDao extends AbstractDao<Integer, User> implements UserDao{
    public User readById(Integer id) {
        return null;
    }

    public User readByPassport(String passport) {
        return null;
    }

    public User readByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    public User readByFullName(String name, String surname) {
        return null;
    }

    public void create(User user) {

    }

    public void update(User user) {

    }

    public void deleteByPassport(String passport) {

    }

    public void deleteByFullName(String name, String surname) {

    }

    public List<User> findAllSortedUsers() {

        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<User> users = criteria.list();
        return users;
    }

    public boolean isUserUnique(Integer id, String passport, String name, String surname) {
        return false;
    }
}
