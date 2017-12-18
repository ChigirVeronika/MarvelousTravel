package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface GroupDao {

    void create(Group group);

    Group read(Integer id);

    void update(Group group);

    void delete(Group group);

    List<Group> readAll();

    Group readForUser(User user);
}
