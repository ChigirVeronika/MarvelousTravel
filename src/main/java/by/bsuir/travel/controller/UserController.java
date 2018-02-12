package by.bsuir.travel.controller;

import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = {"/user/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping(value = {"/user-new"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "user-new";
        }
//        if (!validateUser(user, result, userService)) {
//            return "user-new";
//        }
        userService.save(user);
        //model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        return "main";
    }

    @RequestMapping(value = {"/user/get"}, method = RequestMethod.POST)
    public String tasksList(@RequestParam("email") String email, ModelMap model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "user-get";
    }

    @RequestMapping(value = {"/user/get"}, method = RequestMethod.GET)
    public String tasksList() {
        return "user-get";
    }

}
