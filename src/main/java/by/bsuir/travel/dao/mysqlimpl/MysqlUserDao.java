package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.UserDao;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class MysqlUserDao extends AbstractDao<Integer, User> implements UserDao {
    public User readById(Integer id) {
        return getByKey(id);
    }

    public User readByPassport(String passport) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("passport", passport));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    public User readByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    public User readByEmailAndPassword(String email, String password) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));//TODO do hashing in service
        User user = (User) criteria.uniqueResult();
        return user;
    }

    public User readByFullName(String name, String surname) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("surname", surname));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    public void create(User user) {
        persist(user);
    }

    public void update(User user) {
        updateEntity(user);
    }

    public void deleteByPassport(String passport) {
        User user = readByPassport(passport);
        delete(user);
    }

    public void deleteByFullName(String name, String surname) {
        User user = readByFullName(name, surname);
        delete(user);
    }

    public List<User> findAllSortedUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<User> users = criteria.list();
        return users;
    }

    public boolean isUserUnique(Integer id, String passport, String name, String surname) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("surname", surname));
        criteria.add(Restrictions.eq("passport", passport));
        User user = (User) criteria.uniqueResult();
        if (user == null) {
            return true;
        }
        return false;
    }
}
