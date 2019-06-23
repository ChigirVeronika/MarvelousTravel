package by.bsuir.travel.controller;

import by.bsuir.travel.dto.PlacesTags;
import by.bsuir.travel.entity.Place;
import by.bsuir.travel.entity.Tag;
import by.bsuir.travel.service.PlaceService;
import by.bsuir.travel.service.TagService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static by.bsuir.travel.util.NumberUtil.COUNT;
import static by.bsuir.travel.util.NumberUtil.getRandomNumberInRange;

@Controller
public class MainController {

    private static final Logger LOG = Logger.getLogger(MainController.class);

    @Autowired
    private PlaceService placeService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String goToMain(Model model) {

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

        return "main";
    }

    @RequestMapping(value = {"/addMain"}, method = RequestMethod.POST)
    public String m(@RequestParam(value = "placeIds", required = false) int[] placeIds,
                    @RequestParam(value = "tagIds", required = false) int[] tagIds,
                    ModelMap model) {
        LOG.debug(placeIds);
        List<Place> places = new ArrayList<>();
        for (Integer id : placeIds) {
            places.add(placeService.find(id));
        }
        List<Tag> tags = new ArrayList<>();
        for (Place p : places) {
            tags.addAll(p.getTags());
        }
        for (Integer id : tagIds) {
            tags.add(tagService.find(id));
        }

        Map<String, List<Tag>> unsortedGroups =
                tags.stream().collect(Collectors.groupingBy(Tag::getName));

        List<String> keys = unsortedGroups.entrySet().stream()
                .sorted((left, right) ->
                        Integer.compare(right.getValue().size(), left.getValue().size()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        List<Place> results = new ArrayList<>();
        Tag t1 = getTag(tags, keys, 1);
        Tag t2 = getTag(tags, keys, 2);
        Tag t3 = getTag(tags, keys, 3);
        Tag t4 = getTag(tags, keys, 4);
        results.add(placeService.findRandomByTag(t1));
        results.add(placeService.findRandomByTag(t1));
        results.add(placeService.findRandomByTag(t2));
        results.add(placeService.findRandomByTag(t2));
        results.add(placeService.findRandomByTag(t3));
        model.addAttribute("results", results);
        return "result";
    }

    private Tag getTag(List<Tag> tags, List<String> keys, Integer i) {
        return tags.stream()
                .filter(tag -> keys.get(i).equals(tag.getName()))
                .findFirst().get();
    }
}
