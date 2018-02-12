package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.OrderDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlOrderDao;
import by.bsuir.travel.entity.Order;
import by.bsuir.travel.entity.Tour;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(MysqlOrderDao dao) {
        this.orderDao = dao;
    }

    @Override
    public void saveOrderByTour(Tour tour, User user) {
        Order order = new Order();
        order.setDate(new Date());
        order.setBillingTime(new Date());
        order.setPaid(true);
        order.setTour(tour);
        order.setUser(user);
        orderDao.create(order);
    }

    @Override
    public Order find(Integer id) {
        return orderDao.read(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.readAll();
    }

    @Override
    public List<Order> findAllForUser(User user) {
        return orderDao.readAllForUser(user);
    }

    @Override
    public List<Order> findAllForTour(Tour tour) {
        return orderDao.readAllForTour(tour);
    }
}
