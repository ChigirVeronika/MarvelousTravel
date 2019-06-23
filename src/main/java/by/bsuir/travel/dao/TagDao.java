package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> readAll();

    Tag read(Integer id);

    Tag read(String name);
}
