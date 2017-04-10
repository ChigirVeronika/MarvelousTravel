package by.bsuir.travel.controller;

import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password, Model model, HttpSession session) {

        User persistedUser = userService.findByEmail(email);
        if (persistedUser != null && persistedUser.getPassword().equals(password)) {
            session.setAttribute("user", persistedUser);
            //model.addAttribute("success", "User " + persistedUser.getFirstName() + " "+ persistedUser.getLastName() + " signed in successfully");
            return "main";
        } else {
            model.addAttribute("error", "Incorrect username or password, Please try again!");
            return "index";
        }

    }
}
