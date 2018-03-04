package by.bsuir.travel.service.util;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component("groupServiceUtil")
public class GroupServiceUtil {

    public static Group convertToEntity(GroupDto dto) {
        Group g = new Group();
        g.setName(dto.getName());
        g.setInfo(dto.getInfo());
        return g;
    }

    public static GroupDto convertToDto(Group g) {
        GroupDto dto = new GroupDto();
        Set<User> users = g.getUsers();

        dto.setName(g.getName());
        dto.setInfo(Optional.ofNullable(g.getInfo()).orElse(""));
        dto.setTours(g.getTours());
        dto.setUsers(users);
        dto.setAge(getAverageAge(users));
        dto.setGender(getPrevailingGender(users));
        dto.setMaritalStatus(getPrevailingMaritalStatus(users));
        dto.setIncome(getAverageIncome(users));
        dto.setIsParent(getIsParent(users));

        return dto;
    }

    public static Boolean getPrevailingMaritalStatus(Set<User> users) {//todo maybe change logic
        long married = users.stream()
                .filter(u -> u.getMaritalStatus().equals(true))
                .count();
        long single = users.stream()
                .filter(u -> u.getMaritalStatus().equals(false))
                .count();
        if (married > single) {
            return true;
        }
        return false;
    }

    public static Boolean getIsParent(Set<User> users) {//todo maybe change logic
        long parent = users.stream()
                .filter(u -> u.getIsParent().equals(true))
                .count();
        long no = users.stream()
                .filter(u -> u.getIsParent().equals(false))
                .count();
        if (parent > no) {
            return true;
        }
        return false;
    }

    public static Integer getAverageAge(Set<User> users) {
        List<Date> birthdays = users.stream()
                .map(User::getBirthday)
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
        } catch (Exception e) {
        }

        return average.intValue();
    }

    public static Double getAverageIncome(Set<User> users) {
        List<Double> incomes = users.stream()
                .map(User::getIncome)
                .collect(Collectors.toList());

        Double average = 0.0;
        try {
            average = incomes.stream()
                    .mapToDouble(a -> a)
                    .average()
                    .getAsDouble();
        } catch (Exception e) {
        }

        return average;
    }

    public static String getPrevailingGender(Set<User> users) {//todo maybe change logic
        long genderF = users.stream()
                .filter(u -> u.getGender().contains("F"))
                .count();
        long genderM = users.stream()
                .filter(u -> u.getGender().contains("M"))
                .count();
        if (Math.abs(genderF - genderM) < users.size() / 10) {
            return "MF";
        }
        if (genderF > genderM) {
            return "F";
        }
        return "M";
    }
}
