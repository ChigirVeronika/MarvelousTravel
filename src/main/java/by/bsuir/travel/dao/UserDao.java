package by.bsuir.travel.dao;

import by.bsuir.travel.entity.User;

import java.util.List;


public interface UserDao {

    User findById(Integer id);

    User findByPassport(String passport);

    User findByEmail(String email);

	User findByFullName(String name, String surname) ;

    void saveUser(User user);

    void updateUser(User user);

    void deleteByPassport(String passport);

	void deleteByFullName(String name, String surname) ;

    List<User> findAllSortedUsers();

    boolean isUserUnique(Long id, String passport, String name, String surname);

}

