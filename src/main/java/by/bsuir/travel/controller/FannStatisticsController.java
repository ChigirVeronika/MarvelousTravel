package by.bsuir.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/fann-statistics")
public class FannStatisticsController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showFannStatPage(ModelMap model) {
        return "fann-statistics";
    }

    @RequestMapping(value = {"/calculate/easy"}, method = RequestMethod.GET)
    public String easyTrainAndWork(@RequestParam Boolean increment,
                                   @RequestParam Boolean batch,
                                   @RequestParam Boolean rprop,
                                   ModelMap model) throws Exception {


        return "fann-statistics-result";
    }

    @RequestMapping(value = {"/calculate/heavy"}, method = RequestMethod.GET)
    public String heavyTrainAndWork(@RequestParam Boolean increment,
                                   @RequestParam Boolean batch,
                                   @RequestParam Boolean rprop,
                                   ModelMap model) throws Exception {


        return "fann-statistics-result";
    }

    @RequestMapping(value = {"/calculate/both"}, method = RequestMethod.GET)
    public String bothTrainAndWork(ModelMap model) throws Exception {


        return "fann-statistics-result";
    }

}
