package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Statistic;
import by.bsuir.travel.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Statistic> statistic = statisticService.findAll();

        model.addAttribute("statistic", statistic);
        return "statistics";
    }

}
