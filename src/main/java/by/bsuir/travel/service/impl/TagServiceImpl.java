package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.TagDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlTagDao;
import by.bsuir.travel.entity.Tag;
import by.bsuir.travel.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    public TagServiceImpl() {
    }

    public TagServiceImpl(MysqlTagDao dao) {
        this.tagDao = dao;
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.readAll();
    }

    @Override
    public Tag find(Integer id) {
        return tagDao.read(id);
    }

    @Override
    public Tag find(String name) {
        return tagDao.read(name);
    }
}
