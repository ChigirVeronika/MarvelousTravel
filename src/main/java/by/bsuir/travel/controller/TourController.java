package by.bsuir.travel.controller;

import by.bsuir.travel.dto.TourDto;
import by.bsuir.travel.entity.*;
import by.bsuir.travel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private CountryService countryService;

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
        List<String> cities = cityService.findAll().stream()
                .map(City::getName)
                .collect(Collectors.toList());
        model.addAttribute("cities", cities);
        List<String> countries = countryService.findAll().stream()
                .map(Country::getName)
                .collect(Collectors.toList());
        model.addAttribute("countries", countries);
        List<String> months = getNextMonths(12);
        model.addAttribute("months", months);

        return "tour-panel";
    }

    private List<String> getNextMonths(Integer amount) {
        List<String> monthList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MMM-yyyy");

        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < amount; i++) {
            String monthName = format.format(calendar.getTime());
            monthList.add(monthName);
            calendar.add(Calendar.MONTH, +1);
        }
        return monthList;
    }

    @RequestMapping(value = {"/tour/panel"}, method = RequestMethod.POST)
    public String searchForTours(TourDto tourDto, ModelMap model) throws ParseException {
        List<Tour> tours = tourService.findAllForTourDtoParams(tourDto);
        //List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "tour-list";
    }

    @RequestMapping(value = {"/tour/list"}, method = RequestMethod.GET)
    public String getAllTours(ModelMap model) {
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "tour-list";
    }

    @RequestMapping(value = {"/tour/list/group"}, method = RequestMethod.GET)
    public String getAllToursForUserGroup(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Group group = user.getGroup();
        List<Tour> tours = tourService.findAllForGroup(group);
        model.addAttribute("tours", tours);
        return "tour-list";
    }

    @RequestMapping(value = {"/tour/get/{id}"}, method = RequestMethod.GET)
    public String getTour(@PathVariable Integer id, HttpSession session) {
        //todo add to statistics IMPORTANT!!!
        Tour tour = tourService.find(id);
        User u = (User) session.getAttribute("user");
        User user = userService.findById(u.getId());
        orderService.saveOrderByTour(tour, user);
        return "greeting";
    }

}
