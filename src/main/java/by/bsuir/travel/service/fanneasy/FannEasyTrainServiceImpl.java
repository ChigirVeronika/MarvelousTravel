package by.bsuir.travel.service.fanneasy;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.service.GroupService;
import com.googlecode.fannj.*;
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

@Service("annTrainService")
public class FannEasyTrainServiceImpl implements FannEasyTrainService {
    private static final String FILE_PATH = "D:\\IdeaProjects\\MarvelousTravel\\data\\";
    private static final String TRAINING_FILE_NAME = "training-set-";
    private static final String RESULT_FILE_NAME = "result-";
    private static final String FILE_TYPE = "data";
    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private GroupService groupService;

    @Override
    public Fann createTrainingFileAndTrainAndSaveToResultFile(List<GroupDto> groupDtos) throws Exception {
        Fann fann = train(groupDtos);
        return fann;
    }

    private Fann train(List<GroupDto> dtos) throws Exception {
        LocalDateTime dateTime = LocalDateTime.now();
        String trainingFileName = createFileName(FILE_PATH, TRAINING_FILE_NAME, FILE_TYPE, dateTime);
        String resultFileName = createFileName(FILE_PATH, RESULT_FILE_NAME, FILE_TYPE, dateTime);

        createTrainingFile(dtos, trainingFileName);
        Fann fann = createAndTrainAnn(trainingFileName);
        saveAnnToResultFile(fann, resultFileName);

        return fann;
    }

    private void createTrainingFile(List<GroupDto> dtos, String trainingFileName) throws Exception {
        new File(trainingFileName);
        Path path = Paths.get(trainingFileName);

        writeFirstLine(dtos, path);
        writeAllLines(dtos, path);
    }

    private void writeFirstLine(List<GroupDto> dtos, Path path) throws Exception {
        String firstLine = dtos.size() + " "
                + USER_PARAMS_NUMBER + " " + dtos.size();
        Files.write(path, Arrays.asList(firstLine), Charset.forName("UTF-8"));
    }

    private void writeAllLines(List<GroupDto> dtos, Path path) throws Exception {
        for (GroupDto dto : dtos) {
            String groupNumberString = formGroupNumberString(dtos, dto);
            String groupParamsString = formGroupParamsString(dto);//form user string
            Files.write(path,
                    Arrays.asList(groupNumberString, groupParamsString),
                    Charset.forName("UTF-8"));//put user & group string

        }
    }

    private String formGroupParamsString(GroupDto dto) {
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

    private String formGroupNumberString(List<GroupDto> groups, GroupDto group) {
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

    private String createFileName(String path, String name, String type, LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String now = dateTime.format(formatter);
        return path + name + now + "." + type;
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
}
