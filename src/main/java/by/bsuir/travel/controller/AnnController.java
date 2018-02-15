package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import by.bsuir.travel.service.fann.FannTrainService;
import by.bsuir.travel.service.fann.FannWorkService;
import com.googlecode.fannj.Fann;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/ann")
public class AnnController {

    @Autowired
    private FannTrainService fannTrainService;

    @Autowired
    private FannWorkService fannWorkService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/train"}, method = RequestMethod.GET)
    public String train(ModelMap model) throws Exception {
        List<Group> groups = null;//TODO HOW GET NEEDED GROUPS FROM UI
        Fann fann = fannTrainService.autoTraining(groups);

        List<User> users = null; //TODO
        List<Group> assignedGroups = fannWorkService.autoWork(users, fann);
        return "ann";
    }

}
