package by.bsuir.travel.fann;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.GroupService;
import by.bsuir.travel.service.UserService;
import com.googlecode.fannj.Fann;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("fannWorkService")
public class FannWorkServiceImpl implements FannWorkService {

    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Override
    public Map<User, Group> fullWork(List<User> users, Fann fann) {

        Map<User, Group> resultMap = new HashMap<>();

        for (User user : users) {
            float[] data = createWorkData(user);
            Group oldGroup = user.getGroup();
            Group newGroup = getUserGroup(fann, data);

            if (oldGroup != newGroup) {
                user.setGroup(newGroup);
                //userService.update(user); todo 1 - test, 2- uncomment
                resultMap.put(user, newGroup);
            }
        }
        return resultMap;
    }

    private float[] createWorkData(User user) {
        float[] data = new float[USER_PARAMS_NUMBER];
        Years age = Years.yearsBetween(new org.joda.time.LocalDate(user.getBirthday()), org.joda.time.LocalDate.now());
        data[0] = age.getYears();
        data[1] = user.getGender() == "M" ? 1 : 0;
        data[2] = user.getMaritalStatus() ? 1 : 0;
        data[3] = (float) (user.getIncome() / 1000);
        data[4] = user.getIsParent() ? 1 : 0;
        return data;
    }

    private Group getUserGroup(Fann fann, float[] workData) {
        Integer groupNumber = getGroupNumber(fann.run(workData));
        //TODO?????? UPDATE ALL IDS IN USER_ORDER
        Group group = groupService.find(groupNumber);
        return group;
    }

    private Integer getGroupNumber(float[] out) {
        Integer groupsCount = groupService.findAll().size();
        int i = 0;
        for (int j = 1; j < groupsCount; j++) {
            if (out[i] < out[j]) {
                i = j;
            }
        }
        return i + 1;
    }
}
