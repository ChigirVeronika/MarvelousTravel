package by.bsuir.travel.fann;

import by.bsuir.travel.dto.GroupDto;
import com.googlecode.fannj.Fann;

public interface FannEasyTrainService {
    Fann fullyTrain(GroupDto[] dtos) throws Exception;//most likely to manage order of dtos in list
}
