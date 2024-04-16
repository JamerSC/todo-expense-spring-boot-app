package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Gender;
import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {


    @Value("${gender}")
    private List<String> genders;

    // Show form & Create a model
    @GetMapping("/showLogin")
    public String showLogin(Model model) {
        // display the date
        // model.addAttribute("theDate", java.time.LocalDateTime.now());
        // create a user object & model
        model.addAttribute("user", new User());

        // create model for gender to display on select element
        model.addAttribute("genders", genders);
        // redirect to login page
        return "login";
    }

    @PostMapping("/processLoginForm")
    public String processLoginForm(@Valid @ModelAttribute("user") User theUser,
                                   BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            // return to login form
            return "login";
        }
        else {
            //log input data
            // return "redirect:/users/index";
            return "index";
        }

    }

    @PostMapping("/processCreateAccount")
    public String processCreateAccount(@ModelAttribute("firstName") String firstName,
                                       @ModelAttribute("lastName") String lastName,
                                       @ModelAttribute("gender") Gender gender,
                                       @ModelAttribute("email") String email,
                                       @ModelAttribute("username") String username,
                                       @ModelAttribute("password") String password,
                                       Model model) {

        User newUser = new User();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setGender(gender); /* Enum Gender*/
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);
        // log
        System.out.println("New username: " + newUser.getUsername());
        // model for new user
        model.addAttribute("newUser", newUser);
        // return to newuser page
        return "newUserPage";
    }

    @GetMapping("/showNewUser")
    public String showNewUser(Model model) {
        // You can add other attributes if needed
        return "newUserPage"; // This is the HTML page where you want to display newUser.Username
    }
    /* Index/Dashboard Page */
    @GetMapping("/showIndex")
    public String showIndex() {
        return "index";
    }


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

    /*

    @GetMapping("/login")
    public String showLogin(Model theModel) {

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "login";
    }

    */

}
