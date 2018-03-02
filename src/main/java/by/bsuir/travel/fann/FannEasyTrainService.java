package by.bsuir.travel.fann;

import by.bsuir.travel.dto.GroupDto;
import com.googlecode.fannj.Fann;

import java.util.List;

public interface FannEasyTrainService {

    Fann fullyTrain(List<GroupDto> dtos) throws Exception;//most likely to manage order of dtos in list
}
