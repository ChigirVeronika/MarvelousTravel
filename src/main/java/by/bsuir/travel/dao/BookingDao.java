package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Booking;

import java.util.List;

public interface BookingDao {

    void create(Booking booking);

    Booking read(Integer id);

    void update(Booking booking);

    void delete(Integer id);

    List<Booking> readAll();
}
