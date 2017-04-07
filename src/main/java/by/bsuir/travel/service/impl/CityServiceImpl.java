package by.bsuir.travel.service.impl;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{
    public List<City> findAll() {
        return null;
    }
}
