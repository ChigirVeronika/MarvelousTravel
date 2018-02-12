package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.UserDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlUserDao;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(MysqlUserDao dao) {
        this.userDao = dao;
    }

    @Override
    public void save(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAllSortedUsers();
    }

    @Override
    public User findById(Integer id) {
        return userDao.readById(id);
    }

    @Override
    public User findByPassport(String passport) {
        return userDao.readByPassport(passport);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.readByEmail(email);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.readByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findByFullName(String name, String surname) {
        return userDao.readByFullName(name, surname);
    }

    @Override
    public boolean isUserUnique(String email, String password) {
        return isUserUnique(email, password);
    }
}
