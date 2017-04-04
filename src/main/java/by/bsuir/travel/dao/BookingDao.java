package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Booking;

public interface BookingDao {

    void create();

    Booking read(Integer id);

    void update();

    void delete();
}
