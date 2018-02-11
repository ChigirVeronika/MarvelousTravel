package by.bsuir.travel.service;

import by.bsuir.travel.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    void save(News news);

    void deleteByName(String name);
}
