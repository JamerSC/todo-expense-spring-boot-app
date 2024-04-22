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

    // Show form & Create a model
    @GetMapping("/showLogin")
    public String showLogin(Model model) {

        // create a user object & model
        model.addAttribute("user", new LoginUser());

        // redirect to login page
        return "login";
    }

    @PostMapping("/processLoginForm")
    public String processLoginForm(@Valid @ModelAttribute("user") LoginUser loginUser,
                                   BindingResult bindingResult, Model model){

        System.out.println("Username: |" + loginUser.getLoginUsername() + "|");
        System.out.println("Password: |" + loginUser.getLoginPassword() + "|");

        if (bindingResult.hasErrors()) {
            // return to login form
            return "login";
        }
        else {
            User user = new User();
            //log input data
            user.setUsername(loginUser.getLoginUsername());
           // user.setPassword(loginUser.getLoginPassword());

            model.addAttribute("user", user);
            // return "redirect:/users/index";
            return "index";
        }

    }
    // redirect to create account page
    @GetMapping("/createAccount")
    public  String createAccount(Model model) {
//
//        AccountCreationValidation user = new AccountCreationValidation();

        model.addAttribute("createUser", new CreateUser());

        // create model for gender to display on select element
        model.addAttribute("genders", genders);

        return "create-account";

    }

    @PostMapping("/processCreateAccount")
    public String processCreateAccount(@Valid @ModelAttribute("createUser")
                                       CreateUser createUser,
                                       BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {

            // create model for gender to display on select element
            model.addAttribute("genders", genders);

            return "create-account";

        }

        else {
            // create an object & set the model attribute
            User user = new User();

            user.setFirstName(createUser.getCreateFirstName());
            user.setLastName(createUser.getCreateLastName());
            user.setGender(createUser.getCreateGender()); /* Enum Gender*/
            user.setEmail(createUser.getCreateEmail());
            user.setUsername(createUser.getCreateUsername());
            user.setPassword(createUser.getCreatePassword());

            // console log
            System.out.println("New User Details: " + user);

            // model for new user
            model.addAttribute("user", user);

            // return to new user page
            return "new-user-page";
        }

    }

    @GetMapping("/showNewUser")
    public String showNewUser(Model model) {
        // You can add other attributes if needed
        return "new-user-page"; // This is the HTML page where you want to display newUser.Username
    }
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

    // Http Servlet Process
    /*
    @RequestMapping("/processLoginSecond")
    public String processLoginSecond(HttpServletRequest request, Model model) {
        // Create an object & get the parameter
        String theUsername = request.getParameter("username");
        // Convert the object into upper case
        theUsername = theUsername.toUpperCase();
        // create a message
        String result = "Hey " + theUsername;
        // add message to the model
        model.addAttribute("message", result);
        return "index";
    }
     */

    // Request Param Annotation
    /*
    @PostMapping("/processLoginThird")
    public String processLoginThird(
            @RequestParam("username") String theUsername, Model model) {
        // Convert the object into upper case
        theUsername = theUsername.toUpperCase();
        // create a message
        String result = "Hey " + theUsername;
        // add message to the model
        model.addAttribute("message", result);
        return "index";
    }
     */

}
