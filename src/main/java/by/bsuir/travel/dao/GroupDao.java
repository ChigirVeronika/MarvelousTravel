package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface GroupDao {

    void create(Group group);

    Group read(Integer id);

    void update(Group group);

    void delete(Integer id);

    void deleteByName(String name);

    List<Group> readAll();

    Group readForUser(User user);
}
