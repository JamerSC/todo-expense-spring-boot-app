package com.jamersc.springboot.todoexpense.rest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todoexpense")
public class RestController {

    @GetMapping("/index")
    public String showIndex() {
    // public String showIndex(Model theModel) {

        // theModel.addAttribute("theDate", new java.util.Date());

        return "index";
    }
}
