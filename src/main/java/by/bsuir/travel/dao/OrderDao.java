package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Order;
import by.bsuir.travel.entity.Tour;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface OrderDao {
    void create(Order order);

    Order read(Integer id);

    List<Order> readAll();

    List<Order> readAllForUser(User user);

    List<Order> readAllForTour(Tour tour);
}
