package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.CityDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlCityDao;
import by.bsuir.travel.entity.City;
import by.bsuir.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDao cityDao;

    public CityServiceImpl(){}
    public CityServiceImpl(MysqlCityDao dao){this.cityDao = dao;}

    public List<City> findAll() {
        return cityDao.readAll();
    }

}
