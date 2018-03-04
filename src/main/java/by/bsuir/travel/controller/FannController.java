package by.bsuir.travel.controller;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.fann.FannEasyTrainService;
import by.bsuir.travel.service.GroupService;
import by.bsuir.travel.service.UserService;
import by.bsuir.travel.fann.FannHeavyTrainService;
import by.bsuir.travel.fann.FannWorkService;
import com.googlecode.fannj.Fann;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/fann")
public class FannController {

    @Autowired
    private FannHeavyTrainService fannHeavyTrainService;

    @Autowired
    private FannEasyTrainService fannEasyTrainService;

    @Autowired
    private FannWorkService fannWorkService;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String showFannPage(ModelMap model) throws Exception {
        return "fann";
    }

    @RequestMapping(value = {"/trainwork/easy"}, method = RequestMethod.GET)
    public String easyTrainAndWork(@Valid GroupDto dto, ModelMap model) throws Exception {
        List<GroupDto> dtos = groupService.findAllDtos();
        //dtos.add(dto); TODO UNCOMMENT

        normaliseIncomeValues(dtos);

        Fann fann = fannEasyTrainService.fullyTrain(dtos);

        //find users close by params to group dto
        List<User> usersSuspicionOfChange = userService.findSimilarToGroupDto(dto);
        //recheck group for them
        Map<User, Group> changedUsers = fannWorkService.fullWork(usersSuspicionOfChange, fann);

        model.addAttribute("changedUsersEasy", changedUsers);
        return "fann";//todo??? page with statistics
    }

    private void normaliseIncomeValues(List<GroupDto> dtos) {
        List<Double> incomes = dtos.stream()
                .map(GroupDto::getIncome)
                .collect(Collectors.toList());
        Double maxIncome = incomes.stream()
                .mapToDouble(a -> a)
                .max()
                .getAsDouble();
        for (GroupDto d : dtos) {
            Double newIncome = d.getIncome() / maxIncome;
            d.setIncome(newIncome);
        }
    }

    @RequestMapping(value = {"/trainwork/heavy"}, method = RequestMethod.GET)
    public String heavyTrainAndWork(@Valid GroupDto dto, ModelMap model) throws Exception {

        List<Group> groups = groupService.findAll();
        Fann fann = fannHeavyTrainService.fullyTrain(groups, dto);

        //find users close by params to group dto
        List<User> usersSuspicionOfChange = userService.findSimilarToGroupDto(dto);
        //recheck group for them
        Map<User, Group> changedUsers = fannWorkService.fullWork(usersSuspicionOfChange, fann);

        model.addAttribute("changedUsersHeavy", changedUsers);
        return "fann";
    }

}
