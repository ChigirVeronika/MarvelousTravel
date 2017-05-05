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
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(){}
    public UserServiceImpl(MysqlUserDao dao){this.userDao = dao;}
    public User findById(Long id) {
        return null;
    }

    public User findByPassport(String passport) {

        return null;
    }

    public User findByEmail(String email) {
        return userDao.readByEmail(email);
    }

    public User findByIdNumber(String idNumber) {
        return null;
    }

    public void save(User user) {

    }

    public void update(User user) {

    }

    public void deleteByPassport(String passport) {

    }

    public List<User> findAllSortedUsers() {
        return userDao.findAllSortedUsers();
    }

    public boolean isUserUnique(Long id, String passport) {
        return false;
    }

    public boolean isUserEmailUnique(Long id, String email) {
        return false;
    }
}
