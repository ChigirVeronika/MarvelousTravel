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
import java.util.List;

@Service("fannWorkService")
public class FannWorkServiceImpl implements FannWorkService {

    private static final int USER_PARAMS_NUMBER = 5;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Override
    public List<Group> autoWork(List<User> users, Fann fann) {
        List<Group> groups = new ArrayList<>();
        for (User user : users) {
            float[] data = createWorkData(user);
            Group group = getUserGroup(fann, data);
            groups.add(group);
            //todo add logic is group changed or not
            //todo get users which groups changed/unchanged
            user.setGroup(group);
            userService.update(user);
        }
        return groups;
    }

    @Override
    public float[] createWorkData(User user) {
        float[] data = new float[USER_PARAMS_NUMBER];
        Years age = Years.yearsBetween(new org.joda.time.LocalDate(user.getBithday()), org.joda.time.LocalDate.now());
        data[0] = age.getYears();
        data[1] = user.getGender() == "M" ? 1 : 0;
        data[2] = user.getMaritalStatus() ? 1 : 0;
        data[3] = (float) (user.getIncome() / 1000);
        data[4] = user.getParent() ? 1 : 0;
        return data;
    }

    @Override
    public Group getUserGroup(Fann fann, float[] workData) {
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
