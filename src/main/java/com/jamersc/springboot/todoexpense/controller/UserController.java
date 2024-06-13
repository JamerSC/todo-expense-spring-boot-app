package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.dto.LoginUser;
import com.jamersc.springboot.todoexpense.dto.ManageUser;
import com.jamersc.springboot.todoexpense.model.User;
import com.jamersc.springboot.todoexpense.service.UserService;
import jakarta.validation.Valid;
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
            User user = userService.loginUser(loginUser);
            if (user != null) {
                return "todo-expense/dashboard";
            } else {
                result.rejectValue("loginPassword", "error.loginUser",
                        "Invalid Username or Password!");
                return "todo-expense/login";
            }
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
        } else {
            User user = userService.manageUser(createAccount);
            if (user != null) {
                result.rejectValue("username", "error.createAccount",
                        "Invalid! Username '" + createAccount.getUsername() + "' already exist!");
                return "./forms/create-account-form";
            } else {
                userService.saveUser(createAccount);
                model.addAttribute("user", createAccount);
                return "todo-expense/new-user-page";
            }
        }
    }

    @GetMapping("/dashboard")
    public String showIndex(Model model) {
        // navigation active
        model.addAttribute("activeNav", "dashboard");
        return "todo-expense/dashboard";
    }

    @GetMapping("/users-management")
    public String showUsersManagement(Model model) {
        List<User> users = userService.findAllUser();
        // console logs
        for (User tempUsers : users) {
            System.out.println(tempUsers);
        }
        model.addAttribute("activeNav", "users");
        model.addAttribute("users", users);
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
        } else {
            User user = userService.manageUser(createUser);
            if (user != null) {
                result.rejectValue("username", "error.createUser",
                        "Invalid! Username '" + createUser.getUsername() + "' already exist!");
                return "./forms/user-management-form";
            } else {
                userService.saveUser(createUser);
                return "redirect:/users/users-management";
            }
        }
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") Integer userId, Model model) {
        ManageUser manageUser = userService.findUserById(userId);
        if (manageUser != null) {
            model.addAttribute("user", manageUser);
            return "./forms/user-management-update-form";
        }
        return "redirect:/users/users-management";
    }

    @PostMapping("/updateUser")
    public String processUpdateUser(@Valid @ModelAttribute("user") ManageUser updateUser,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "./forms/user-management-update-form";
        } else {
            ManageUser manageUser = userService.findUserById(updateUser.getId());
            if (manageUser != null) {
                userService.saveUser(updateUser);
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
