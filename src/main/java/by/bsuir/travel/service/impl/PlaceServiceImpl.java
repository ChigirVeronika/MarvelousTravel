package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.PlaceDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlPlaceDao;
import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Tag;
import by.bsuir.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.bsuir.travel.util.NumberUtil.getRandomNumberInRange;

@Service("placeService")
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao placeDao;

    public PlaceServiceImpl() {
    }

    public PlaceServiceImpl(MysqlPlaceDao dao) {
        this.placeDao = dao;
    }

    @Override
    public List<Place> findAll() {
        return placeDao.readAll();
    }

    @Override
    public Place find(Integer id) {
        return placeDao.read(id);
    }

    @Override
    public Place find(String name) {
        return placeDao.read(name);
    }

    @Override
    public List<Place> findLike(String name) {
        return placeDao.readLike(name);
    }

    @Override
    public void save(Place place) {
        placeDao.create(place);
    }

    @Override
    public Place findRandomByTags(Tag one, Tag two) {
        List<Place> places = placeDao.readByTags(one, two);
        Integer i = getRandomNumberInRange(0, places.size() - 1);
        return places.get(i);
    }

    @Override
    public Place findRandomByTag(Tag one) {
        List<Place> places = placeDao.readByTag(one);
        Integer i = getRandomNumberInRange(0, places.size() - 1);
        return places.get(i);
    }
}
