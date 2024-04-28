package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.User;
import com.jamersc.springboot.todoexpense.validation.CreateUser;
import com.jamersc.springboot.todoexpense.validation.LoginUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

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

            return "index";
        }

    }
    // redirect to create account page
    @GetMapping("/createAccount")
    public  String createAccount(Model model) {

        model.addAttribute("createUser", new CreateUser());

        model.addAttribute("genders", genders);

        return "create-account";

    }

    @PostMapping("/createAccount")
    public String processCreateAccount(@Valid @ModelAttribute("createUser") CreateUser createUser,
                                       BindingResult result, Model model) {

            System.out.println("New User Details: " + createUser);

            if (result.hasErrors()) {

                model.addAttribute("genders", genders);

                return "create-account";

            }
            else {
                User user = new User();

                user.setFirstName(createUser.getCreateFirstName());
                user.setLastName(createUser.getCreateLastName());
                user.setGender(createUser.getCreateGender());
                user.setEmail(createUser.getCreateEmail());
                user.setUsername(createUser.getCreateUsername());
                user.setPassword(createUser.getCreatePassword());

                model.addAttribute("user", user);

                System.out.println("Created Account: " + user);

                return "new-user-page";
            }

    }

    /*
    @GetMapping("/showNewUser")
    public String showNewUser(Model model) {
        // You can add other attributes if needed
        return "new-user-page"; // This is the HTML page where you want to display newUser.Username
    }
    */

    /* Index/Dashboard Page */
    @GetMapping("/showIndex")
    public String showIndex() {
        return "index";
    }

    /*
        public String processCreateAccount(@Valid @ModelAttribute("createFirstName") String createFirstName,
                                       @ModelAttribute("createLastName") String createLastName,
                                       @ModelAttribute("createGender") Gender createGender,
                                       @ModelAttribute("createEmail") String createEmail,
                                       @ModelAttribute("createUsername") String createUsername,
                                       @ModelAttribute("createPassword") String createPassword,
                                       BindingResult bindingResult,
                                       Model model) {
     */


}
