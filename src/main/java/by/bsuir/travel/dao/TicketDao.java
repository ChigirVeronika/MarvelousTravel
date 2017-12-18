package by.bsuir.travel.dao;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Ticket;

import javax.swing.text.Document;
import java.sql.Timestamp;
import java.util.List;

public interface TicketDao {

    void create(Ticket ticket);

    Ticket read(Integer id);

    void update(Ticket ticket);

    void delete(Integer id);

    List<Ticket> readAll();

    List<Ticket> readAllForTravel(City from, City to);

    List<Ticket> readAllForTravel(City from, City to, Timestamp date);

    List<Ticket> readAllForTravel(City from, City to, Timestamp date, Double price);

    List<Ticket> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo,Double price);

    List<Ticket> readAllForTravel(City from, City to, Timestamp dateFrom, Timestamp dateTo, Double priceFrom, Double priceTo);
}
