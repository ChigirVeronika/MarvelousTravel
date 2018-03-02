package by.bsuir.travel.fann.util;

import by.bsuir.travel.dto.GroupDto;
import com.googlecode.fannj.Fann;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class FannUtil {

    public static String createFileName(String path, String name, String type, LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String now = dateTime.format(formatter);
        return path + name + now + "." + type;
    }

    public static void saveAnnToResultFile(Fann fann, String resultFileName) {
        fann.save(resultFileName);
    }

    public static String formGroupParamsString(GroupDto dto) {
        String result = "";
        result += Integer.valueOf(dto.getAge()).toString();
        result += " ";
        String gender = dto.getGender() == "M" ? "1" : "0";
        result += gender;
        result += " ";
        String maritalStatus = dto.getMaritalStatus() ? "1" : "0";
        result += maritalStatus;
        result += " ";
        result += new Double(dto.getIncome() / 1000).toString();
        result += " ";
        String isParent = dto.getIsParent() ? "1" : "0";
        result += isParent;
        return result;
    }

    public static String formGroupNumberString(List<GroupDto> groups, GroupDto group) {
        int groupsNumber = groups.size();
        String result = "";

        for (int i = 0; i < groupsNumber; i++) {
            if (i == groups.indexOf(group)) {
                result += "1 ";
            } else {
                result += "0 ";
            }
            if (i != groupsNumber - 1) {
                result += " ";
            }
        }
        return result;
    }
}
