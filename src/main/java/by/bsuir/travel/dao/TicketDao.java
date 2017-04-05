package by.bsuir.travel.dao;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Ticket;

import java.sql.Timestamp;
import java.util.List;

public interface TicketDao {
    void create(Ticket ticket);

    Ticket read(Integer id);

    void update(Ticket ticket);

    void delete(Integer id);

    List<Ticket> readAll();

    List<Ticket> readAllForTravel(City from, City to);

    List<Ticket> readAllForTravelAndDate(City from, City to, Timestamp date);

    List<Ticket> readAllForTravelAndDateAndPrice(City from, City to,
                                                 Timestamp date, Double price);
}
