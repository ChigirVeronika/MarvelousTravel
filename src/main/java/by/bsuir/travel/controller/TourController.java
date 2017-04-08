package by.bsuir.travel.controller;

import by.bsuir.travel.entity.*;
import by.bsuir.travel.service.CityService;
import by.bsuir.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class TourController {
    //@Autowired
    //private TourService tourService;

    @Autowired
    private CityService cityService;



    @RequestMapping(value = {"/tour/panel"}, method = RequestMethod.GET)
    public String getTourPanel(ModelMap model) {
        Tour tour = new Tour();
        model.addAttribute("tour", tour);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "tour-panel";
    }

    @RequestMapping(value = {"/tour/panel"}, method = RequestMethod.POST)
    public String getTours(@Valid Tour tour, ModelMap model) {
        //List<Tour> tours = tourService.findAllForCitiesAndDates();
        //model.addAttribute("tours", tours);
        return "tour-panel";
    }

    @RequestMapping(value = {"/tour/get/{id}"}, method = RequestMethod.GET)
    public String getTour(@PathVariable Integer id){
        //TODO add to statistics IMPORTANT!!!
        return "greeting";
    }

}
