package by.bsuir.travel.dao;

import by.bsuir.travel.entity.News;

import java.util.List;
import java.util.Set;

public interface NewsDao {
    void create(News news);

    News read(Integer id);

    List<News> readAll();

    void update(News news);

    void delete(Integer id);
}
