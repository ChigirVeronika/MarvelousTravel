package by.bsuir.travel.dao;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Hotel;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface HotelDao {

    void create(Hotel hotel);

    Hotel read(Integer id);

    void update(Hotel hotel);

    void delete(Integer id);

    List<Hotel> readAll();

    List<Hotel> readAllForCity(City city);

    List<Hotel> readAllForName(String name);

    List<Hotel> readAllForStars(Integer stars);

    List<Hotel> readAllForStarsInRange(Integer lowerLimit, Integer upperLimit);
}
