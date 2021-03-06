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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password, Model model, HttpSession session) {
        User persistedUser = userService.findByEmailAndPassword(email, password);
        if (persistedUser != null) {
            session.setAttribute("user", persistedUser);
            //model.addAttribute("success", "User " + persistedUser.getFirstName() + " "+ persistedUser.getLastName() + " signed in successfully");
            //model.addAttribute("greeting", "Welcome " + persistedUser.getFirstName() + " "+ persistedUser.getLastName() + "!");
            return "main";
        } else {
            model.addAttribute("error", "Wrong credentials");
            return "index";
        }
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
