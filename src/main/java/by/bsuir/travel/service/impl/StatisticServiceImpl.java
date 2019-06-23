package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.StatisticDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlStatisticDao;
import by.bsuir.travel.entity.Statistic;
import by.bsuir.travel.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("statisticService")
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticDao statisticDao;

    public StatisticServiceImpl(){}
    public StatisticServiceImpl(MysqlStatisticDao dao){
        this.statisticDao = dao;
    }

    @Override
    public List<Statistic> findAll() {
        return statisticDao.readAll();
    }
}
