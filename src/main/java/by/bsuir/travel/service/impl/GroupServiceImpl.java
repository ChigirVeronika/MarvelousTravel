package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.GroupDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlGroupDao;
import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.GroupService;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static by.bsuir.travel.service.util.GroupServiceUtil.*;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    public GroupServiceImpl() {
    }

    public GroupServiceImpl(MysqlGroupDao dao) {
        this.groupDao = dao;
    }

    public List<GroupDto> findAllDtos() {
        List<Group> groups = groupDao.readAll();
        List<GroupDto> dtos = new ArrayList<>();
        for (Group g : groups) {
            dtos.add(convertToDto(g));
        }
        return dtos;
    }

    @Override
    public List<Group> findAll() {
        return groupDao.readAll();
    }


    public GroupDto findDto(Integer id) {
        Group group = groupDao.read(id);
        GroupDto dto = convertToDto(group);
        return dto;
    }

    @Override
    public Group find(Integer id) {
        return groupDao.read(id);
    }


    public void save(GroupDto group) {
        Group g = convertToEntity(group);
        //todo recreate training file, retrain ann, reassign users to groups
        groupDao.create(g);
        //TODO LOGIC --ADD TO-- TRAINING FILE!!!
    }

    public void update(GroupDto group) {
        Group g = convertToEntity(group);
        //todo recreate training file, retrain ann, reassign users to groups
        groupDao.update(g);
        //TODO LOGIC --CHANGE-- TRAINING FILE!!!
    }

    public void delete(Integer id) {
        groupDao.delete(id);
        //TODO LOGIC --DELETE FROM-- TRAINING FILE!!!
    }

    public void delete(String name) {
        groupDao.deleteByName(name);
        //TODO LOGIC --DELETE FROM-- TRAINING FILE!!!
    }

}
