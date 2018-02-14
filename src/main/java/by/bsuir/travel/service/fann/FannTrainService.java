package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface FannTrainService {

    String createTrainingFile(List<Group> groups) throws Exception;//all groups

    void trainANNAndSaveToFile(String resultFileName);

    void deleteOldFiles();

}
