package com.jamersc.springboot.todoexpense.rest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @GetMapping("/")
    public String showIndex(Model theModel) {

        theModel.addAttribute("theDate", new java.util.Date());

        return "index";
    }
}
