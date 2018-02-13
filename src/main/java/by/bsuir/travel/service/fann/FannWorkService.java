package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;

public interface FannWorkService {

    float[] createWorkData(User user);

    Group workAndGetUserGroup(float[] workData);

}
