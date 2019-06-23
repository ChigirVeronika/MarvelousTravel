package by.bsuir.travel.controller;

import by.bsuir.travel.dto.RatingDto;
import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Rating;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.PlaceService;
import by.bsuir.travel.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = {"/rate"}, method = RequestMethod.POST)
    public String create(@RequestParam("placeId") Integer placeId,
                         @RequestParam("mark") Integer mark,
                         ModelMap model, HttpSession session) {
        Place place = placeService.find(placeId);
        User user = (User) session.getAttribute("user");
        Rating rating = new Rating(mark, user, place);
        ratingService.save(rating);

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

    //    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
//    public String list(ModelMap model) {
//        RatingDto dto = new RatingDto();
//        model.addAttribute("ratingDto", dto);
//
//        List<Rating> ratings = ratingService.findAll();
//        model.addAttribute("ratings", ratings);
//        return "rating-list";
//    }

//    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
//    public String create(@Valid RatingDto feedbackDto,
//                         ModelMap model, HttpSession session) {
//        RatingDto dto = new RatingDto();
//        model.addAttribute("ratingDto", dto);
//
//        Rating rating = new Rating();
//        rating.setMark(feedbackDto.getMark());
//        rating.setUser((User) session.getAttribute("user"));
//
//        ratingService.save(rating);
//
//        return "redirect:/rating/list";
//    }
}
