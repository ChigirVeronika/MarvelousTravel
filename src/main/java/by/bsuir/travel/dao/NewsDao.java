package by.bsuir.travel.dao;

import by.bsuir.travel.entity.News;

import java.sql.Timestamp;
import java.util.List;

public interface NewsDao {

    void create(News news);

    News read(Integer id);

    void update(News news);

    void delete(Integer id);

    void delete(String name);

    List<News> readAll();

    List<News> readAllForName(String name);

    List<News> readAllForDate(Timestamp date);

    List<News> readAllForDatesInRange(Timestamp lowerLimit, Timestamp upperLimit);
}
