package by.bsuir.travel.service;

import by.bsuir.travel.entity.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group find(Integer id);

    void save(Group group);

    void update(Group group);

    void delete(Integer id);

}
