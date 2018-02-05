package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.VisitDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlVisitDao;
import by.bsuir.travel.entity.Visit;
import by.bsuir.travel.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;

    public VisitServiceImpl (){}
    public VisitServiceImpl(MysqlVisitDao dao) {
        this.visitDao = dao;
    }

    @Override
    public void save(Visit visit) {
        visitDao.save(visit);
    }
}
