package by.bsuir.travel.dao;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Hotel;

import java.util.List;

public interface HotelDao {
    void create(Hotel hotel);

    Hotel read(Integer id);

    void update(Hotel hotel);

    void delete(Integer id);

    List<Hotel> readAll();

    List<Hotel> readAllForCity(City city);
}
