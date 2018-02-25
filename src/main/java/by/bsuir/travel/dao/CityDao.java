package by.bsuir.travel.dao;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Country;

import java.util.List;

public interface CityDao {

    void create(City city);

    City read(Integer id);

    City readByName(String name);

    void update(City city);

    void delete(Integer id);

    List<City> readAll();

    List<City> readAllForCountry(Country country);
}
