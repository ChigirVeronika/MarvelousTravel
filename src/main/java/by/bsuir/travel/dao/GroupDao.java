package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Group;

import java.util.List;

public interface GroupDao {

    List<Group> readAll();

    Group read(Integer id);

    void create(Group group);

    void update(Group group);

    void delete(Group group);
}
