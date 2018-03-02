package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.UserDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlUserDao;
import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.util.resources.cldr.ar.CalendarData_ar_YE;

import java.util.Calendar;
import java.util.Date;
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
    public List<User> findSimilarToGroupDto(GroupDto dto) {
        User user = new User();

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.YEAR, -dto.getAge());
        Date dateOfBirth = cal.getTime();
        user.setBithday(dateOfBirth);

        cal.add(Calendar.YEAR, -10);
        Date older = cal.getTime();
        cal.add(Calendar.YEAR, +20);
        Date newer = cal.getTime();

        user.setGender(dto.getGender());
        user.setMaritalStatus(dto.getMaritalStatus());
        user.setIncome(dto.getIncome());
        user.setParent(dto.getIsParent());

        return userDao.readSimilarTo(user, older, newer);
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
    public List<User> findByGroup(Group group) {
        return userDao.readByGroup(group);
    }

    @Override
    public boolean isUserUnique(String email, String password) {
        return isUserUnique(email, password);
    }
}
