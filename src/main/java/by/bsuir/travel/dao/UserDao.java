package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

import java.util.List;


public interface UserDao {

    void create(User user);

    User readById(Integer id);

    User readByPassport(String passport);

    User readByEmail(String email);

    User readByEmailAndPassword(String email, String password);

    List<User> readByGroup(Group group);

    List<User> readByFullName(String name, String surname);

    void update(User user);

    void deleteByPassport(String passport);

    List<User> findAllSortedUsers();

    boolean isUserUnique(String email, String passport);

}

