package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.CityDao;
import by.bsuir.travel.dao.CountryDao;
import by.bsuir.travel.dao.TourDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlCityDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlCountryDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlTourDao;
import by.bsuir.travel.dto.TourDto;
import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Tour;
import by.bsuir.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("tourService")
@Transactional
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDao tourDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountryDao countryDao;

    public TourServiceImpl() {
    }

    public TourServiceImpl(MysqlTourDao dao, MysqlCityDao cityDao, MysqlCountryDao countryDao) {
        this.tourDao = dao;
        this.cityDao = cityDao;
        this.countryDao = countryDao;
    }

    @Override
    public Tour find(Integer id) {
        return tourDao.read(id);
    }

    public List<Tour> findAll() {
        return tourDao.readAll();
    }

    public List<Tour> findAllForCitiesAndDates(Tour tour) {
        return tourDao.readAllForCitiesAndDates(tour);
    }

    @Override
    public List<Tour> findAllForTourDtoParams(TourDto dto) throws ParseException {
        City cityFrom = cityDao.readByName(dto.getCityFrom());

        Country country = countryDao.readByName(dto.getCountry());
        List<City> citiesTo = cityDao.readAllForCountry(country);

        SimpleDateFormat uiFormat = new SimpleDateFormat("MMM-yyyy");
        Date date = uiFormat.parse(dto.getMonth());

        Double priceTopLimit = Double.valueOf(dto.getPriceTopLimit());

        return tourDao.readAllForTravel(cityFrom, citiesTo, date, priceTopLimit);
    }
}
