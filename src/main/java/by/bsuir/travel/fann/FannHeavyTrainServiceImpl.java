package by.bsuir.travel.fann;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.GroupService;
import by.bsuir.travel.service.UserService;
import com.googlecode.fannj.*;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.bsuir.travel.fann.util.FannUtil.createFileName;
import static by.bsuir.travel.fann.util.FannUtil.formGroupParamsString;

@Service("fannTrainService")
public class FannHeavyTrainServiceImpl implements FannHeavyTrainService {

    private static final String FILE_PATH = "D:\\IdeaProjects\\MarvelousTravel\\data\\";
    private static final String TRAINING_FILE_NAME = "heavy-training-set-";
    private static final String RESULT_FILE_NAME = "heavy-result-";
    private static final String FILE_TYPE = "data";
    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Override
    public Fann fullyTrain(List<Group> groups, GroupDto dto) throws Exception {

        LocalDateTime dateTime = LocalDateTime.now();
        String trainingFileName = createFileName(FILE_PATH, TRAINING_FILE_NAME, FILE_TYPE, dateTime);
        String resultFileName = createFileName(FILE_PATH, RESULT_FILE_NAME, FILE_TYPE, dateTime);

        createTrainingFile(groups, dto, trainingFileName);
        Fann fann = createAndTrainAnn(trainingFileName);
        saveAnnToResultFile(fann, resultFileName);

        return fann;
    }

    private void createTrainingFile(List<Group> groups, GroupDto dto, String trainingFileName) throws Exception {
        new File(trainingFileName);
        Path path = Paths.get(trainingFileName);

        writeFirstLine(groups, path);
        writeAllLines(groups, dto, path);
    }

    private Fann createAndTrainAnn(String trainingFileName) {
        int groupsNumber = groupService.findAll().size();

        System.setProperty("jna.library.path", "D:\\IdeaProjects\\MarvelousTravel\\src\\main\\resources\\ann\\");
        new File(System.getProperty("jna.library.path") + "fannfloat.dll");

        List<Layer> layerList = new ArrayList<>();
        layerList.add(Layer.create(USER_PARAMS_NUMBER, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(USER_PARAMS_NUMBER * groupsNumber, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(groupsNumber, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));

        Fann fann = new Fann(layerList);
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);

        trainer.train(new File(trainingFileName).getAbsolutePath(),
                100000, 100, 0.0001f);
        return fann;
    }

    private void saveAnnToResultFile(Fann fann, String resultFileName) {
        fann.save(resultFileName);
    }

    @Override
    public void deleteOldFiles() {
        throw new UnsupportedOperationException();
    }

    private void writeFirstLine(List<Group> groups, Path path) throws Exception {
        int numberOfTrainings = userService.findAll().size() + 1;
        String firstLine = numberOfTrainings + " "
                + USER_PARAMS_NUMBER + " " + Integer.valueOf(groups.size() + 1);
        Files.write(path, Arrays.asList(firstLine), Charset.forName("UTF-8"));
    }

    private void writeAllLines(List<Group> groups, GroupDto dto, Path path) throws Exception {
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
        String groupParamsString = formGroupParamsString(dto);
        String groupNumberString = formGroupNumberString(groups);
        Files.write(path,
                Arrays.asList(groupParamsString, groupNumberString),
                Charset.forName("UTF-8"));//put user & group string
    }

    private String formUserString(User u) {
        String result = "";
        Years a = Years.yearsBetween(new org.joda.time.LocalDate(u.getBithday()), org.joda.time.LocalDate.now());
        result += String.valueOf(a.getYears());
        result += " ";
        String gender = u.getGender() == "M" ? "1" : "0";
        result += gender;
        result += " ";
        String maritalStatus = u.getMaritalStatus() ? "1" : "0";
        result += maritalStatus;
        result += " ";
        result += String.valueOf(new Double(u.getIncome() / 1000));
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
                result += "1 ";
            } else {
                result += "0 ";
            }
            if (i != groupsNumber - 1) {
                result += " ";
            }
            if (i == groupsNumber - 1) {//todo check if the logic is correct
                result += " 0";
            }
        }
        return result;
    }

    private String formGroupNumberString(List<Group> groups){
        String result = "";
        for (int i = 0; i < groups.size(); i++) {
            result += "0 ";
        }
        result+= "1";
        return result;
    }

}
