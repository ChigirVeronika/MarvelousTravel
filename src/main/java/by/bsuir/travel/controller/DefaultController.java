package by.bsuir.travel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class DefaultController {
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String goToIndex() {
        return "index";
    }

    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String goToMain() {
        return "main";
    }

    @RequestMapping(value={"/google/map"}, method = RequestMethod.GET)
    public String showGoogleMap() {
        return "google-map";
    }
}
