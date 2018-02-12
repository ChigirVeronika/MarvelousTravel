package by.bsuir.travel.controller;

import by.bsuir.travel.dto.TourDto;
import by.bsuir.travel.entity.*;
import by.bsuir.travel.service.CityService;
import by.bsuir.travel.service.OrderService;
import by.bsuir.travel.service.TourService;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class TourController {
    @Autowired
    private TourService tourService;

    @Autowired
    private CityService cityService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(java.sql.Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = {"/tour/panel"}, method = RequestMethod.GET)
    public String getTourPanel(ModelMap model) {
        TourDto dto = new TourDto();
        model.addAttribute("tourDto", dto);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "tour-panel";
    }

    @RequestMapping(value = {"/tour/panel"}, method = RequestMethod.POST)
    public String searchForTours(@Valid TourDto tourDto,
                                 ModelMap model) {
        Tour tour = new Tour();
        tour.setStartDate(tourDto.getStartDate());
        tour.setEndDate(tourDto.getEndDate());
        tour.setCityFrom(tourDto.getCityFrom());
        tour.setCityTo(tourDto.getCityTo());
        List<Tour> tours = tourService.findAllForCitiesAndDates(tour);
        model.addAttribute("tours", tours);
        return "tour-list";
    }

    @RequestMapping(value = {"/tour/list"}, method = RequestMethod.GET)
    public String getAllTours(ModelMap model) {
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "tour-list";
    }

    @RequestMapping(value = {"/tour/get/{id}"}, method = RequestMethod.GET)
    public String getTour(@PathVariable Integer id, HttpSession session) {
        //todo add to statistics IMPORTANT!!!
        Tour tour = tourService.find(id);
        User user = userService.findById(1);//TODO! Get user from session
        orderService.saveOrderByTour(tour, user);
        return "greeting";
    }

}
