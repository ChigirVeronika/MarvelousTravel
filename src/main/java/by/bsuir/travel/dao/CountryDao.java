package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;

import java.util.List;

public interface CountryDao {

    void create(Country country);

    Country read(Integer id);

    void update(Country country);

    void delete(Integer id);

    List<Country> readAll();

    List<Country> readAllForRegion(Region region);
}
