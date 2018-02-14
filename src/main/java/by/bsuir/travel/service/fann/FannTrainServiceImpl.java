package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service("fannTrainService")
public class FannTrainServiceImpl implements FannTrainService {

    private static final String TRAINING_FILE_PATH = "D:\\IdeaProjects\\MarvelousTravel\\data\\";
    private static final String TRAINING_FILE_NAME = "training_set";
    private static final String TRAINING_FILE_TYPE = ".data";
    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private UserService userService;

    @Override
    public String createTrainingFile(List<Group> groups) throws Exception {
        String fileName = createTrainingFileName();
        new File(fileName);
        Path path = Paths.get(fileName);

        writeFirstLine(groups, path);

        writeAllLines(groups, path);

        return fileName;
    }

    @Override
    public void trainANNAndSaveToFile(String resultFileName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteOldFiles() {
        throw new UnsupportedOperationException();
    }

    private void writeFirstLine(List<Group> groups, Path path) throws Exception {
        String firstLine = userService.findAll().size() + " " //TODO!!! all users who have groups !!!
                + USER_PARAMS_NUMBER + " " + groups.size();
        Files.write(path, Arrays.asList(firstLine), Charset.forName("UTF-8"));
    }

    private void writeAllLines(List<Group> groups, Path path) throws Exception {
        for (Group group : groups) {
            List<User> users = userService.findByGroup(group);
            String groupString = formGroupString(groups, group);//form user string

            for (User u : users) {
                String userString = formUserString(u);//form user string
                Files.write(path,
                        Arrays.asList(userString, groupString),
                        Charset.forName("UTF-8"));//put user & group string
            }
        }
    }

    private String formUserString(User u) {
        String result = "";
        Years a = Years.yearsBetween(new org.joda.time.LocalDate(u.getBithday()), org.joda.time.LocalDate.now());
        result += Integer.valueOf(a.getYears()).toString();
        result += " ";
        String gender = u.getGender() == "M" ? "1" : "0";
        result += gender;
        result += " ";
        String maritalStatus = u.getMaritalStatus() ? "1" : "0";
        result += maritalStatus;
        result += " ";
        result += new Double(u.getIncome() / 1000).toString();
        result += " ";
        String isParent = u.getParent() ? "1" : "0";
        result += isParent;
        return result;
    }

    private String formGroupString(List<Group> groups, Group group) {
        int groupsNumber = groups.size();
        String result = "";

        for (int i = 0; i < groupsNumber; i++) {
            if (i == groups.indexOf(group)) {
                result += "1";
            } else {
                result += "0";
            }
            if (i != groupsNumber - 1) {
                result += " ";
            }
        }
        return result;
    }

    private String createTrainingFileName() {
        String now = LocalDate.now().toString();
        return TRAINING_FILE_PATH +
                TRAINING_FILE_NAME + now +
                TRAINING_FILE_TYPE;
    }
}
