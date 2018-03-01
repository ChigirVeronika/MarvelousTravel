package by.bsuir.travel.service.fanneasy;

import by.bsuir.travel.dto.GroupDto;
import com.googlecode.fannj.Fann;

import java.util.List;

public interface FannEasyTrainService {
    Fann createTrainingFileAndTrainAndSaveToResultFile(List<GroupDto> groupDtos) throws Exception;//most likely to manage order of dtos in list
}
