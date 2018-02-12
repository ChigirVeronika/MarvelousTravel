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
        List<User> users = userService.findAllSortedUsers();
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

//    private boolean validateUser(UserOld user, BindingResult result, UserService userService){
//
////        if (!userService.isUserEmailUnique(user.getId(), user.getIdNumber())) {
////            FieldError ssoError = new FieldError("user", "email", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getIdNumber()}, Locale.getDefault()));
////            result.addError(ssoError);
////            return false;
////        }
//
//        ////
//        if (!user.getFirstName().matches("[a-zA-Z]+")) {
//            FieldError error = new FieldError("user", "firstName", messageSource.getMessage("Letters.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//        if (!user.getLastName().matches("[a-zA-Z]+")) {
//            FieldError error = new FieldError("user", "lastName", messageSource.getMessage("Letters.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//        if (!user.getMiddleName().matches("[a-zA-Z]+")) {
//            FieldError error = new FieldError("user", "middleName", messageSource.getMessage("Letters.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//
//        // TODO: 9/7/2016 birthday
//        if (user.getGender() == null | user.getGender().trim().length() == 0) {
//            FieldError error = new FieldError("user", "gender", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//
//        if (!userService.isUserUnique(user.getId(), user.getIdNumber())) {
//            FieldError ssoError = new FieldError("user", "passportSeriesAndNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(ssoError);
//            return false;
//        }
//        if (user.getWhomGranted() == null | user.getWhomGranted().trim().length() == 0) {
//            FieldError error = new FieldError("user", "whomGranted", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//        // TODO: 9/7/2016 granted date
//        if (user.getIdNumber() == null | user.getIdNumber().trim().length() == 0) {
//            FieldError error = new FieldError("user", "idNumber", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//        if (!userService.isUserIdNumberUnique(user.getId(), user.getIdNumber())) {
//            FieldError ssoError = new FieldError("user", "idNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(ssoError);
//            return false;
//        }
//        if (user.getBirthPlace() == null | user.getBirthPlace().trim().length() == 0) {
//            FieldError error = new FieldError("user", "birthPlace", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
//        if (user.getAccommodationAddress() == null | user.getAccommodationAddress().trim().length() == 0) {
//            FieldError error = new FieldError("user", "accommodationAddress", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(error);
//            return false;
//        }
////        if (user.getMonthIncome() != null)
////            if (!user.getMonthIncome().toString().matches("[0-9]+")) {
////                FieldError error = new FieldError("user", "monthIncome", messageSource.getMessage("Numbers.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
////                result.addError(error);
////                return false;
////            }
//
//
//        return true;
//    }*/
}
