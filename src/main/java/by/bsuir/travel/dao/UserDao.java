package by.bsuir.travel.dao;

import by.bsuir.travel.entity.User;

import java.util.List;


public interface UserDao {

    User findById(Long id);

    User findByPassport(String series, String number);

    User findByEmail(String email);

    User findByIdNumber(String idNumber);

//	User findByFullName(String first, String second, String middle) ;

    void saveUser(User user);

    void updateUser(User user);

    void deleteByPassport(String series, String number);

//	void deleteByFullName(String first, String second, String middle) ;

    List<User> findAllSortedUsers();

    boolean isUserUnique(Long id, String series, String number);

}

