package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.dao.AbstractDao;
import by.bsuir.travel.dao.OrderDao;
import by.bsuir.travel.entity.Order;
import by.bsuir.travel.entity.Tour;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("orderDao")
@Transactional
public class MysqlOrderDao extends AbstractDao<Integer, Order> implements OrderDao {
    @Override
    public void create(Order order) {
        persist(order);
    }

    @Override
    public Order read(Integer id) {
        return getByKey(id);
    }

    @Override
    public List<Order> readAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Order> orders = criteria.list();
        return orders;
    }

    @Override
    public List<Order> readAllForUser(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("user", user));
        List<Order> orders = criteria.list();
        return orders;
    }

    @Override
    public List<Order> readAllForTour(Tour tour) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("tour", tour));
        List<Order> orders = criteria.list();
        return orders;
    }
}
