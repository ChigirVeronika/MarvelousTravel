package by.bsuir.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class UserController {

    /*private static final Logger LOGGER = Logger.getLogger(UserController.class);

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

        List<UserOld> users = userService.findAllSortedUsers();

        model.addAttribute("users", users);
        return "userslist";
    }

    @RequestMapping(value = {"/sign-in"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        UserOld user = new UserOld();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "create-user";
    }

    @RequestMapping(value = {"/create-user"}, method = RequestMethod.POST)
    public String saveUser(@Valid UserOld user, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "create-user";
        }

        if (!validateUser(user, result, userService)) {
            return "create-user";
        }

        userService.saveUser(user);

        model.addAttribute("success", "UserOld " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        return "home";
    }

    @RequestMapping(value = {"/edit-user-{passportSeriesAndNumber}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String passportSeriesAndNumber, ModelMap model) {
        UserOld user = userService.findByPassport(passportSeriesAndNumber);

        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "create-user";
    }

    @RequestMapping(value = {"/edit-user-{passportSeriesAndNumber}"}, method = RequestMethod.POST)
    public String updateUsers(@Valid UserOld user, BindingResult result,
                              ModelMap model, @PathVariable String passportSeriesAndNumber) {
        if (result.hasErrors()) {
            return "create-user";
        }

            if (!validateUser(user, result, userService)) {
                return "create-user";
            }
            userService.updateUser(user);

        model.addAttribute("success", "UserOld " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        return "home";
    }

    @RequestMapping(value = {"/delete-user-{passportSeriesAndNumber}"}, method = RequestMethod.GET)
    public String deleteUsers(@PathVariable String passportSeriesAndNumber) {
            userService.deleteByPassport(passportSeriesAndNumber);

        return "redirect:/list";
    }

    private boolean validateUser(UserOld user, BindingResult result, UserService userService){

//        if (!userService.isUserEmailUnique(user.getId(), user.getIdNumber())) {
//            FieldError ssoError = new FieldError("user", "email", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getIdNumber()}, Locale.getDefault()));
//            result.addError(ssoError);
//            return false;
//        }

        ////
        if (!user.getFirstName().matches("[a-zA-Z]+")) {
            FieldError error = new FieldError("user", "firstName", messageSource.getMessage("Letters.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if (!user.getLastName().matches("[a-zA-Z]+")) {
            FieldError error = new FieldError("user", "lastName", messageSource.getMessage("Letters.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if (!user.getMiddleName().matches("[a-zA-Z]+")) {
            FieldError error = new FieldError("user", "middleName", messageSource.getMessage("Letters.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }

        // TODO: 9/7/2016 birthday
        if (user.getGender() == null | user.getGender().trim().length() == 0) {
            FieldError error = new FieldError("user", "gender", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }

        if (!userService.isUserUnique(user.getId(), user.getIdNumber())) {
            FieldError ssoError = new FieldError("user", "passportSeriesAndNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(ssoError);
            return false;
        }
        if (user.getWhomGranted() == null | user.getWhomGranted().trim().length() == 0) {
            FieldError error = new FieldError("user", "whomGranted", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        // TODO: 9/7/2016 granted date
        if (user.getIdNumber() == null | user.getIdNumber().trim().length() == 0) {
            FieldError error = new FieldError("user", "idNumber", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if (!userService.isUserIdNumberUnique(user.getId(), user.getIdNumber())) {
            FieldError ssoError = new FieldError("user", "idNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(ssoError);
            return false;
        }
        if (user.getBirthPlace() == null | user.getBirthPlace().trim().length() == 0) {
            FieldError error = new FieldError("user", "birthPlace", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if (user.getAccommodationAddress() == null | user.getAccommodationAddress().trim().length() == 0) {
            FieldError error = new FieldError("user", "accommodationAddress", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
//        if (user.getMonthIncome() != null)
//            if (!user.getMonthIncome().toString().matches("[0-9]+")) {
//                FieldError error = new FieldError("user", "monthIncome", messageSource.getMessage("Numbers.user.text", new String[]{user.getIdNumber()}, Locale.getDefault()));
//                result.addError(error);
//                return false;
//            }


        return true;
    }*/
}
