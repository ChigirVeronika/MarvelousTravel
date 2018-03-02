package by.bsuir.travel.controller;

import by.bsuir.travel.dto.UserDto;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
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

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String getUserRegisterPage(ModelMap model) {
        UserDto user = new UserDto();
        model.addAttribute("userDto", user);
        return "user-create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String saveUser(@Valid UserDto userDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "user-create";
        }
        User user = convertToEntity(userDto);

        if (!userService.isUserUnique(user.getEmail(), user.getPassword())) {
            FieldError error = new FieldError("user", "email", "Bad email or password.");
            result.addError(error);
            return "user-create";
        }
        userService.save(user);
        model.addAttribute("success", "User " + user.getName() + " " + user.getSurname() + " registered successfully");
        return "main";
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.POST)
    public String getUserByEmail(@RequestParam("email") String email, ModelMap model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "user-get";
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public String getUserPage() {
        return "user-get";
    }

    @RequestMapping(value = {"/personal"}, method = RequestMethod.GET)
    public String getUserPersonalPage(HttpSession session) {
        User user = (User) session.getAttribute("user");

        return "user-personal";
    }

    @RequestMapping(value = {"/personal"}, method = RequestMethod.POST)
    public String updateUser(@Valid UserDto userDto, ModelMap model) {
        User user = userService.findByEmail(userDto.getEmail());
        User fromDto = convertToEntity(userDto);
        fromDto.setId(user.getId());
        userService.update(fromDto);
        return "redirect:/user/list";
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setBithday(userDto.getBirthday());
        user.setGender(userDto.getGender());
        user.setPassport(userDto.getPassport());
        user.setPhone(userDto.getPhone());
        user.setMaritalStatus(userDto.getMaritalStatus());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setIncome(userDto.getIncome());
        user.setParent(userDto.getParent());
        user.setHome(userDto.getHome());
        //user.setRole();//todo!!!
        //user.setGroup();
        return user;
    }
}
