package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;
import by.bsuir.travel.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class RegionController {
    @Autowired
    private RegionService regionService;

    @RequestMapping(value = {"/news-list"}, method = RequestMethod.GET)
    public String newsList(ModelMap model) {
        //List<News> news = newsService.getAll();
        Map<Region, List<Country>> map = regionService.getRegionsWithCountries();
        model.addAttribute("regionMap", map);
        return "countries-list";
    }
}
