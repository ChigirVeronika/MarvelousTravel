package by.bsuir.travel.controller;

import by.bsuir.travel.service.UserService;
import by.bsuir.travel.fann.FannEasyTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/ann")
public class AnnController {
    @Autowired
    private FannEasyTrainService annTrainService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String showAnnPage(ModelMap model) throws Exception {
        return "ann";
    }

}
