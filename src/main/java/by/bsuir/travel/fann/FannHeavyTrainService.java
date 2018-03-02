package by.bsuir.travel.fann;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import com.googlecode.fannj.Fann;

import java.util.List;

public interface FannHeavyTrainService {

    Fann fullyTrain(List<Group> groups, GroupDto dto) throws Exception;

//    void createTrainingFile(List<Group> groups, String trainingFileName) throws Exception;//all groups
//
//    Fann createAndTrainAnn(String trainingFileName);
//
//    void saveAnnToResultFile(Fann fann, String resultFileName);

    void deleteOldFiles();

}
