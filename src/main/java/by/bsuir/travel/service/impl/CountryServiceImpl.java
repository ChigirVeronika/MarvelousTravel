package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.CountryDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlCountryDao;
import by.bsuir.travel.entity.Country;
import by.bsuir.travel.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    public CountryServiceImpl() {
    }

    public CountryServiceImpl(MysqlCountryDao dao) {
        this.countryDao = dao;
    }

    public Country find(Integer id) {
        return countryDao.read(id);
    }

    public List<Country> findAll() {
        return countryDao.readAll();
    }
}
