package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.model.User;
import com.jamersc.springboot.todoexpense.dto.ManageUser;
import com.jamersc.springboot.todoexpense.dto.LoginUser;
import com.jamersc.springboot.todoexpense.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // init binder & resolve issues for validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @GetMapping("/login")
    public String showLogin(Model model) {

        model.addAttribute("loginUser", new LoginUser());

        return "todo-expense/login";
    }

    @PostMapping("/login")
    public String processLoginForm(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
                                   BindingResult result, Model model){


        if (result.hasErrors()) {

            return "todo-expense/login";

        }
        else {

            User user = new User();

            user.setUsername(loginUser.getLoginUsername());
            user.setPassword(loginUser.getLoginPassword());

            //model.addAttribute("user", user);

            System.out.println("Login Username: " + user.getUsername());

            return "todo-expense/dashboard";
        }

    }
    // redirect to create account page
    @GetMapping("/createAccount")
    public  String createAccount(Model model) {

        model.addAttribute("user", new ManageUser());
        return "./forms/create-account-form";

    }

    @PostMapping("/createAccount")
    public String processCreateAccount(@Valid @ModelAttribute("user") ManageUser createAccount,
                                       BindingResult result, Model model) {

            System.out.println("New User Details: " + createAccount);

            if (result.hasErrors()) {

                return "./forms/create-account-form";

            }
            else {

                User user = new User();

                // reduce redundancy & boilerplate
                BeanUtils.copyProperties(createAccount, user);

                userService.saveUser(user);

                model.addAttribute("user", createAccount);

                return "todo-expense/new-user-page";
            }

    }

    /* Index/Dashboard Page */
    @GetMapping("/dashboard")
    public String showIndex() {
        return "todo-expense/dashboard";
    }

    @GetMapping("/users-management")
    public String showUsersManagement(Model model) {

        List<User> users = userService.findAllUser();

        model.addAttribute("users", users);

        // logs
        for (User tempUsers : users) {
            System.out.println(tempUsers);
        }

        return "todo-expense/users-management";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {

        model.addAttribute("user", new ManageUser());
        return "./forms/user-management-form";
    }

    @PostMapping("/createUser")
    public String processCreateUser(@Valid @ModelAttribute("user") ManageUser createUser,
                                    BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "./forms/user-management-form";
        }
        else {

            User user = new User();

            BeanUtils.copyProperties(createUser, user);

            userService.saveUser(user);

            return "redirect:/users/users-management";
        }
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") Integer userId, Model model) {

        User id = userService.findUserById(userId);

        model.addAttribute("user", id);
        return "./forms/user-management-update-form";
    }

    @PostMapping("/updateUser")
    public String processUpdateUser(@Valid @ModelAttribute("user") ManageUser updateUser,
                                    BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "./forms/user-management-update-form";
        }
        else {

            User user = userService.findUserById(updateUser.getId());

            if (user != null) {

                BeanUtils.copyProperties(updateUser, user);

                userService.saveUser(user);
            }

            return "redirect:/users/users-management";
        }
    }



    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Integer id) {

        userService.deleteUserById(id);

        return "redirect:/users/users-management";
    }

}
