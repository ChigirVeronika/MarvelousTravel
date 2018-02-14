package by.bsuir.travel.service;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;

import java.util.List;

public interface GroupService {

    List<GroupDto> findAllDtos();

    List<Group> findAll();

    GroupDto find(Integer id);

    void save(GroupDto group);

    void update(GroupDto group);

    void delete(Integer id);

    void delete(String name);

}
