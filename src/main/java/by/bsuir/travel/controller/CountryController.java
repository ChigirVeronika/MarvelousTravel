package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Country;
import by.bsuir.travel.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = {"/get/{id}"}, method = RequestMethod.GET)
    public String get(@PathVariable Integer id, ModelMap model) {
        Country country = countryService.find(id);
        model.addAttribute("country", country);
        return "country";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "country-list";
    }
}
