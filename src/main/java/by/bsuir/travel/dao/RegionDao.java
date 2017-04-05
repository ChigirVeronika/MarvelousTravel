package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Region;

import java.util.List;

public interface RegionDao {
    void create(Region region);

    Region read(Integer id);

    void update(Region region);

    void delete(Integer id);

    List<Region> readAll();
}
