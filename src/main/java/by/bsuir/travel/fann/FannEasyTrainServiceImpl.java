package by.bsuir.travel.fann;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.service.GroupService;
import by.bsuir.travel.fann.entity.TrainingParams;
import com.googlecode.fannj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.bsuir.travel.fann.util.FannUtil.*;

@Service("annTrainService")
public class FannEasyTrainServiceImpl implements FannEasyTrainService {

    private TrainingParams trainingParams;

    public TrainingParams getTrainingParams() {
        return trainingParams;
    }

    public void setTrainingParams(TrainingParams trainingParams) {
        this.trainingParams = trainingParams;
    }

    private static final String FILE_PATH = "D:\\_D\\MarvelousTravel\\data\\";
    private static final String TRAINING_FILE_NAME = "easy-training-set-";
    private static final String RESULT_FILE_NAME = "easy-result-";
    private static final String FILE_TYPE = "data";
    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private GroupService groupService;

    @Override
    public Fann fullyTrain(List<GroupDto> dtos) throws Exception {

        LocalDateTime dateTime = LocalDateTime.now();
        String trainingFileName = createFileName(FILE_PATH, TRAINING_FILE_NAME, FILE_TYPE, dateTime);
        String resultFileName = createFileName(FILE_PATH, RESULT_FILE_NAME, FILE_TYPE, dateTime);

        createTrainingFile(dtos, trainingFileName);
        Fann fann = createAndTrainAnn(trainingFileName);
        saveAnnToResultFile(fann, resultFileName);

        return fann;
    }

    private void createTrainingFile(List<GroupDto> dtos, String trainingFileName) throws Exception {
        File f = new File(trainingFileName);
        f.getParentFile().mkdirs();
        f.createNewFile();
        PrintWriter out = new PrintWriter(new FileWriter(f, true));
        writeFirstLine(dtos, out);
        writeAllLines(dtos, out);
        out.close();
    }

    private void writeFirstLine(List<GroupDto> dtos, PrintWriter out) throws Exception {
        String firstLine = dtos.size() + " "
                + USER_PARAMS_NUMBER + " " + dtos.size();
        out.append(firstLine+"\n");
    }

    private void writeAllLines(List<GroupDto> dtos, PrintWriter out) throws Exception {
        for (GroupDto dto : dtos) {
            String groupParamsString = formGroupParamsString(dto);
            String groupNumberString = formGroupNumberString(dtos, dto);
            out.append(groupParamsString + "\n");
            out.append(groupNumberString + "\n");
        }
    }

    private Fann createAndTrainAnn(String trainingFileName) {
        int groupsNumber = groupService.findAll().size();

        System.setProperty("jna.library.path", "C:\\Users\\Veranika\\IdeaProjects\\TravelFANN\\src\\main\\resources\\");
        File file = new File(System.getProperty("jna.library.path") + "fannfloat.dll");

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
}
