package by.bsuir.travel.service;

import by.bsuir.travel.entity.Order;
import by.bsuir.travel.entity.Tour;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface OrderService {
    void saveOrderByTour(Tour tour, User user);

    Order find(Integer id);

    List<Order> findAll();

    List<Order> findAllForUser(User user);

    List<Order> findAllForTour(Tour tour);
}
