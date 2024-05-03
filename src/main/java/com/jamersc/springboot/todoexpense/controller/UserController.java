package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.User;
import com.jamersc.springboot.todoexpense.service.UserService;
import com.jamersc.springboot.todoexpense.validation.ManageUser;
import com.jamersc.springboot.todoexpense.validation.LoginUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService theUserService) {
        this.userService = theUserService;
    }

    @Value("${gender}")
    private List<String> genders;

    // init binder & resolve issues for validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @GetMapping("/login")
    public String showLogin(Model model) {

        model.addAttribute("loginUser", new LoginUser());

        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
                                   BindingResult result, Model model){


        if (result.hasErrors()) {

            return "login";

        }
        else {

            User user = new User();

            user.setUsername(loginUser.getLoginUsername());
            user.setPassword(loginUser.getLoginPassword());

            model.addAttribute("user", user);

            System.out.println("Login Username: " + user.getUsername());

            return "dashboard";
        }

    }
    // redirect to create account page
    @GetMapping("/createAccount")
    public  String createAccount(Model model) {

        model.addAttribute("createAccount", new ManageUser());

        model.addAttribute("genders", genders);

        return "/forms/create-account-form";

    }

    @PostMapping("/createAccount")
    public String processCreateAccount(@Valid @ModelAttribute("createAccount") ManageUser createAccount,
                                       BindingResult result, Model model) {

            System.out.println("New User Details: " + createAccount);

            if (result.hasErrors()) {

                model.addAttribute("genders", genders);

                return "/forms/create-account-form";

            }
            else {
                User user = new User();

                user.setFirstName(createAccount.getCreateFirstName());
                user.setLastName(createAccount.getCreateLastName());
                user.setGender(createAccount.getCreateGender());
                user.setEmail(createAccount.getCreateEmail());
                user.setUsername(createAccount.getCreateUsername());
                user.setPassword(createAccount.getCreatePassword());

                model.addAttribute("user", user);

                System.out.println("Created Account: " + user);

                return "new-user-page";
            }

    }

    /* Index/Dashboard Page */
    @GetMapping("/dashboard")
    public String showIndex() {
        return "dashboard";
    }

    @GetMapping("/users-management")
    public String showUsersManagement(Model model) {

        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        // logs
        for (User tempUsers : users) {
            System.out.println(tempUsers);
        }

        return "users-management";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {

        model.addAttribute("createUser", new ManageUser());

        return "/forms/user-management-form";
    }



}
