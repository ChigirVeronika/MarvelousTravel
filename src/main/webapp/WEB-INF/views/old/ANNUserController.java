package by.bsuir.travel.controller;

import by.bsuir.travel.service.ANNUserService;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class ANNUserController {

    @Autowired
    private ANNUserService annService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/user-model-retrain"}, method = RequestMethod.GET)
    public String retrainModel(ModelMap model) {

        annService.retrainANN();


        ///
        model.addAttribute("message", "Model has been successfully retrained.");
        return "message";
    }

}
