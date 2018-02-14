package by.bsuir.travel.service.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import com.googlecode.fannj.Fann;

import java.util.List;

public interface FannWorkService {

    List<Group> autoWork(List<User> users, Fann fann);

    float[] createWorkData(User user);

    Group getUserGroup(Fann fann, float[] workData);

}
