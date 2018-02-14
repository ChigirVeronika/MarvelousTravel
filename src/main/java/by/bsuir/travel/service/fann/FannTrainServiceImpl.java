package by.bsuir.travel.service.fann;

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
import java.nio.charset.CoderResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fannTrainService")
public class FannTrainServiceImpl implements FannTrainService {

    private static final String FILE_PATH = "D:\\IdeaProjects\\MarvelousTravel\\data\\";
    private static final String TRAINING_FILE_NAME = "training-set-";
    private static final String RESULT_FILE_NAME = "result-";
    private static final String FILE_TYPE = "data";
    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;


    @Override
    public Fann autoTraining() throws Exception {
        createTrainingFile(groupService.findAll(), TRAINING_FILE_NAME);
        Fann fann = trainANNAndSaveToFile(TRAINING_FILE_NAME, RESULT_FILE_NAME, true);
        return fann;
    }

    @Override
    public String createTrainingFile(List<Group> groups, String trainingFileName) throws Exception {

        String fileName = createFileName(FILE_PATH, trainingFileName, FILE_TYPE);

        new File(fileName);
        Path path = Paths.get(fileName);

        writeFirstLine(groups, path);

        writeAllLines(groups, path);

        return fileName;
    }

    @Override
    public Fann trainANNAndSaveToFile(String trainingFileName, String resultFileName, boolean provideFullPathAndType) {
        int groupsNumber = groupService.findAll().size();

        System.setProperty("jna.library.path", "D:\\IdeaProjects\\MarvelousTravel\\src\\main\\resources\\ann\\");
        new File(System.getProperty("jna.library.path") + "fannfloat.dll");

        if (provideFullPathAndType) {
            LocalDateTime dateTime = LocalDateTime.now();
            trainingFileName = createFileName(FILE_PATH, trainingFileName, FILE_TYPE, dateTime);
            resultFileName = createFileName(FILE_PATH, resultFileName, FILE_TYPE, dateTime);
        }

        List<Layer> layerList = new ArrayList<>();
        layerList.add(Layer.create(USER_PARAMS_NUMBER, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(USER_PARAMS_NUMBER * groupsNumber, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(groupsNumber, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));

        Fann fann = new Fann(layerList);
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);

        trainer.train(new File(trainingFileName).getAbsolutePath(),
                100000, 100, 0.0001f);

        fann.save(resultFileName);

        return fann;
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

    private String createFileName(String path, String name, String type) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String now = dateTime.format(formatter);
        return path + name + now + "." + type;
    }

    private String createFileName(String path, String name, String type, LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String now = dateTime.format(formatter);
        return path + name + now + "." + type;
    }

}
