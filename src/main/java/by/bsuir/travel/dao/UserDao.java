package by.bsuir.travel.dao;

import by.bsuir.travel.entity.User;

import java.util.List;


public interface UserDao {

    User readById(Integer id);

    User readByPassport(String passport);

    User readByEmail(String email);

	User readByFullName(String name, String surname) ;

    void create(User user);

    void update(User user);

    void deleteByPassport(String passport);

	void deleteByFullName(String name, String surname) ;

    List<User> findAllSortedUsers();

    boolean isUserUnique(Integer id, String passport, String name, String surname);

}

