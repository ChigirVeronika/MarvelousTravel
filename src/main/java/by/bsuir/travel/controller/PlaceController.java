package by.bsuir.travel.controller;

import by.bsuir.travel.entity.City;
import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Rating;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.CityService;
import by.bsuir.travel.service.PlaceService;
import by.bsuir.travel.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import static by.bsuir.travel.util.NumberUtil.getRandomNumberInRange;

@Controller
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Place> places = placeService.findAll();
        model.addAttribute("places", places);
        return "place-list";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String showCreationPage() {
        return "place-create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String create(@RequestParam("name") String name,
                         @RequestParam("about") String about,
                         @RequestParam("cityName") String cityName) {
        City city = cityService.findByName(cityName);
        Place place = new Place(name, about, city);
        placeService.save(place);
        return "redirect:/place/list";
    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.POST)
    public String create(@RequestParam("name") String name, Model model) {
        Place place = placeService.find(name);
        model.addAttribute("place", place);

        List<Rating> ratings = new ArrayList<>();
        ratings.addAll(place.getRatings());
        List<Integer> l = ratings.stream()
                .map(Rating::getMark)
                .collect(Collectors.toList());
        Double average = l.stream()
                    .mapToInt(a -> a)
                    .average()
                    .getAsDouble();
        model.addAttribute("mark", average);
        return "place";
    }
}
