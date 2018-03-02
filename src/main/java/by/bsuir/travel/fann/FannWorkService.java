package by.bsuir.travel.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import com.googlecode.fannj.Fann;

import java.util.List;
import java.util.Map;

public interface FannWorkService {

    Map<User, Group> fullWork(List<User> users, Fann fann);

}
