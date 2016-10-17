package by.bsuir.travel.service;


import by.bsuir.travel.entity.User;

import java.util.List;

public interface UserService {
	
	User findById(Long id);

	User findByPassport(String passportSeriesAndNumber);
	User findByEmail(String email);
	User findByIdNumber(String idNumber);

	//User findByFullName(String first, String second, String middle);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteByPassport(String passportSeriesAndNumber);

	//void deleteByFullName(String first, String second, String middle);

	List<User> findAllSortedUsers();
	
	boolean isUserUnique(Long id, String seriesAndNumber);

	boolean isUserIdNumberUnique(Long id, String idNumber);

	boolean isUserEmailUnique(Long id, String email);

}