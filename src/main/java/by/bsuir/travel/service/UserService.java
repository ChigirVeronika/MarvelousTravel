package by.bsuir.travel.service;


import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface UserService {
	
	void save(User user);
	
	void update(User user);

	List<User> findAll();

	List<User> findSimilarToGroupDto(GroupDto dto);

	User findById(Integer id);

	User findByPassport(String passport);

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	List<User> findByFullName(String name, String surname);

	List<User> findByGroup(Group group);

	boolean isUserUnique(String email, String password);

}