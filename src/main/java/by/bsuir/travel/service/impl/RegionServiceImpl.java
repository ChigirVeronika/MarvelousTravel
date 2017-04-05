package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.CountryDao;
import by.bsuir.travel.dao.RegionDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlRegionDao;
import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;
import by.bsuir.travel.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("regionService")
@Transactional
public class RegionServiceImpl {//implements RegionService {
    /*@Autowired
    private RegionDao regionDao;

    @Autowired
    private CountryDao countryDao;

    public RegionServiceImpl() {
    }

    public RegionServiceImpl(MysqlRegionDao dao) {
        this.regionDao = dao;
    }//todo дописать

    public Map<Region, List<Country>> getRegionsWithCountries() {
        Map<Region, List<Country>> map = new HashMap<Region, List<Country>>();
        List<Region> regions = regionDao.readAll();
        for (Region r : regions) {
            List<Country> properCountries = countryDao.readAllForRegion(r);
            map.put(r, properCountries);
        }
        return map;
    }*/
}
