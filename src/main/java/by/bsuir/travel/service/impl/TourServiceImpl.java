package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.TourDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlTourDao;
import by.bsuir.travel.entity.Tour;
import by.bsuir.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tourService")
@Transactional
public class TourServiceImpl implements TourService{
    @Autowired
    private TourDao tourDao;

    public TourServiceImpl(){}
    public TourServiceImpl(MysqlTourDao dao){this.tourDao = dao;}

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
}
