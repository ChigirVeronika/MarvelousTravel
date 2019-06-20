package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Country;

import java.util.List;

public interface CountryDao {

    void create(Country country);

    Country read(Integer id);

    Country readByName(String name);

    void update(Country country);

    void delete(Integer id);

    List<Country> readAll();
}
