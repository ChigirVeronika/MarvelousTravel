package by.bsuir.travel.service;

import by.bsuir.travel.entity.Country;

import java.util.List;

public interface CountryService {
    Country find(Integer id);

    List<Country> findAll();
}
