package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.NewsDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlNewsDao;
import by.bsuir.travel.entity.News;
import by.bsuir.travel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    public NewsServiceImpl() {
    }

    public NewsServiceImpl(MysqlNewsDao dao) {
        this.newsDao = dao;
    }

    public List<News> findAll() {
        return newsDao.readAll();
    }

    public void save(News news) {
        newsDao.create(news);
    }

    @Override
    public void deleteByName(String name) {
        newsDao.delete(name);
    }
}
