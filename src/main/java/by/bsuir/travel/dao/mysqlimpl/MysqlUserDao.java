package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.UserDao;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    public List<User> readByFullName(String name, String surname) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("surname", surname));
        List<User> users = criteria.list();
        return users;
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

    public List<User> findAllSortedUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<User> users = criteria.list();
        return users;
    }

    public boolean isUserUnique(String email, String passport) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
        if (user == null) {
            return true;
        }
        Criteria criteria2 = createEntityCriteria();
        criteria2.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria2.add(Restrictions.eq("passport", passport));
        User user2 = (User) criteria2.uniqueResult();
        if (user2 == null) {
            return true;
        }
        return false;
    }
}
