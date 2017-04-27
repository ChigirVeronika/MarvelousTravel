package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.GroupDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlGroupDao;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupDao groupDao;

    public GroupServiceImpl() {
    }

    public GroupServiceImpl(MysqlGroupDao dao) {
        this.groupDao = dao;
    }

    public List<Group> findAll() {
        return groupDao.readAll();
    }

    public Group find(Integer id) {
        return groupDao.read(id);
    }

    public void save(Group group) {
        groupDao.create(group);
        //TODO LOGIC --ADD TO-- TRAINING FILE!!!
    }

    public void update(Group group) {
        groupDao.update(group);
        //TODO LOGIC --CHANGE-- TRAINING FILE!!!
    }

    public void delete(Integer id) {
        Group group = groupDao.read(id);
        groupDao.delete(group);
        //TODO LOGIC --DELETE FROM-- TRAINING FILE!!!
    }
}
