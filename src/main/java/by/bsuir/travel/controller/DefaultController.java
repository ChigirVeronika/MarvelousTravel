package by.bsuir.travel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.File;

@RequestMapping("/")
@Controller
public class DefaultController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String goToIndex(HttpSession session) {

        if (session != null) {
            session = null;
        }


        System.setProperty("jna.library.path", "D:\\_D\\MarvelousTravel\\src\\main\\resources\\ann\\");
        File file = new File(System.getProperty("jna.library.path") + "fannfloat.dll");

        return "index";
    }

    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String goToMain() {
        return "main";
    }

    @RequestMapping(value = {"/google/map"}, method = RequestMethod.GET)
    public String showGoogleMap() {
        return "google-map";
    }
}
