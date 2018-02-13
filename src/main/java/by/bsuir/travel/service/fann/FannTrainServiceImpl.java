package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fannTrainService")
public class FannTrainServiceImpl implements FannTrainService {

    @Autowired
    UserService userService;

    @Override
    public String createTrainingFile(List<User> users, List<Group> groups) {
        String trainingFileName = "";



        return trainingFileName;
    }

    @Override
    public void trainAndSaveToFile(String resultFileName) {

    }

    @Override
    public void deleteOldFiles() {

    }

}
