package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Tag;
import by.bsuir.travel.service.PlaceService;
import by.bsuir.travel.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.bsuir.travel.util.NumberUtil.COUNT;
import static by.bsuir.travel.util.NumberUtil.getRandomNumberInRange;

@RequestMapping("/")
@Controller
public class DefaultController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String goToIndex(HttpSession session, Model model) {
        if (session != null) {
            session = null;
        }

        Integer all = placeService.findAll().size();
        List<Place> places = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            int id = getRandomNumberInRange(1, all);
            places.add(placeService.find(id));
        }
        model.addAttribute("places", places);

        Integer all2 = tagService.findAll().size();
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            int id = getRandomNumberInRange(1, all2);
            tags.add(tagService.find(id));
        }
        model.addAttribute("tags", tags);

        return "index";
    }

    @RequestMapping(value = {"/google/map"}, method = RequestMethod.GET)
    public String showGoogleMap() {
        return "google-map";
    }

    @RequestMapping(value = {"/greeting"}, method = RequestMethod.GET)
    public String greeting() {
        return "greeting";
    }
}
