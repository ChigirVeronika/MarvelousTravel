package by.bsuir.travel.service;


import by.bsuir.travel.entity.User;

import java.util.List;

public interface UserService {
	
	User findById(Long id);

	User findByPassport(String passport);
	User findByEmail(String email);
	User findByIdNumber(String idNumber);

	//User findByFullName(String first, String second, String middle);
	
	void save(User user);
	
	void update(User user);
	
	void deleteByPassport(String passport);

	//void deleteByFullName(String first, String second, String middle);

	List<User> findAllSortedUsers();
	
	boolean isUserUnique(Long id, String passport);

	boolean isUserEmailUnique(Long id, String email);

}