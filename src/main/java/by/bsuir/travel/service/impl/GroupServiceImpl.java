package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.GroupDao;
import by.bsuir.travel.dao.mysqlimpl.MysqlGroupDao;
import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.GroupService;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    public GroupServiceImpl() {
    }

    public GroupServiceImpl(MysqlGroupDao dao) {
        this.groupDao = dao;
    }

    public List<GroupDto> findAll() {
        List<Group> groups = groupDao.readAll();
        List<GroupDto> dtos = new ArrayList<>();
        for (Group g : groups) {
            dtos.add(convertToDto(g));
        }
        return dtos;
    }

    public GroupDto find(Integer id) {
        Group group = groupDao.read(id);
        GroupDto dto = convertToDto(group);
        return dto;
    }

    public void save(GroupDto group) {
        Group g = convertToEntity(group);
        groupDao.create(g);
        //TODO LOGIC --ADD TO-- TRAINING FILE!!!
    }

    public void update(GroupDto group) {
        Group g = convertToEntity(group);
        groupDao.update(g);
        //TODO LOGIC --CHANGE-- TRAINING FILE!!!
    }

    public void delete(Integer id) {
        groupDao.delete(id);
        //TODO LOGIC --DELETE FROM-- TRAINING FILE!!!
    }

    private Group convertToEntity(GroupDto dto) {
        Group g = new Group();
        g.setName(dto.getName());
        g.setInfo(dto.getInfo());

        //TODO!!! Add logic to resign users to groups if new group added

        return g;
    }

    private GroupDto convertToDto(Group g) {
        GroupDto dto = new GroupDto();
        Set<User> users = g.getUsers();

        dto.setName(g.getName());
        dto.setInfo(Optional.ofNullable(g.getInfo()).orElse(""));
        dto.setTours(g.getTours());
        dto.setUsers(users);

        dto.setAge(getAverageAge(users));
        dto.setGender(getPrevailingGender(users));

        //todo
        dto.setMaritalStatus(false);
        dto.setIncome(2000.00);
        dto.setIsParent(false);

        return dto;
    }

    private Integer getAverageAge(Set<User> users) {
        List<Date> birthdays = users.stream()
                .map(User::getBithday)
                .collect(Collectors.toList());

        List<Integer> userAges = birthdays.stream()
                .map(b ->
                {
                    Years a = Years.yearsBetween(new LocalDate(b), LocalDate.now());
                    return a.getYears();
                })
                .collect(Collectors.toList());

        Double average = 0.0;
        try {
            average = userAges.stream()
                    .mapToInt(a -> a)
                    .average()
                    .getAsDouble();
        } catch (Exception e) {}

        return average.intValue();
    }

    private String getPrevailingGender(Set<User> users) {//todo maybe change logic
        long genderF = users.stream()
                .filter(u -> u.getGender().contains("F"))
                .count();
        long genderM = users.stream()
                .filter(u -> u.getGender().contains("M"))
                .count();
        if (genderF > genderM) {
            return "F";
        }
        return "M";
    }
}
