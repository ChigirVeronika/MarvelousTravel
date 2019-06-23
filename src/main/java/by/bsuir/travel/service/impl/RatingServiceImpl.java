package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.RatingDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlRatingDao;
import by.bsuir.travel.entity.Rating;
import by.bsuir.travel.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ratingService")
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingDao ratingDao;

    public RatingServiceImpl() {
    }

    public RatingServiceImpl(MysqlRatingDao dao) {
        this.ratingDao = dao;
    }

    @Override
    public List<Rating> findAll() {
        return ratingDao.readAll();
    }

    @Override
    public void save(Rating rating) {
        ratingDao.create(rating);
    }
}
