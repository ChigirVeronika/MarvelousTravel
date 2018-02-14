package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import com.googlecode.fannj.Fann;

import java.util.List;

public interface FannTrainService {
    Fann autoTraining() throws Exception;

    Fann autoTraining(List<Group> groups) throws Exception;

    void createTrainingFile(List<Group> groups, String trainingFileName) throws Exception;//all groups

    Fann createAndTrainAnn(String trainingFileName);

    void saveAnnToResultFile(Fann fann, String resultFileName);

    void deleteOldFiles();

}
