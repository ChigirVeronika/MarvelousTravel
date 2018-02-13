package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

import java.util.List;

public interface FannTrainService {

    String createTrainingFile(List<User> users, List<Group> groups);

    void trainAndSaveToFile(String resultFileName);

    void deleteOldFiles();

}
