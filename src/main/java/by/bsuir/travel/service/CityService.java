package by.bsuir.travel.service;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Country;

import java.util.List;

public interface CityService {
    List<City> findAll();

    City findByName(String name);
}
