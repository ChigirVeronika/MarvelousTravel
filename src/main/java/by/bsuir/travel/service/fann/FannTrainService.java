package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import com.googlecode.fannj.Fann;

import java.util.List;

public interface FannTrainService {
    Fann autoTraining() throws Exception;

    String createTrainingFile(List<Group> groups, String trainingFileName) throws Exception;//all groups

    Fann trainANNAndSaveToFile(String trainingFileName, String resultFileName, boolean provideFullPathAndType);

    void deleteOldFiles();

}
