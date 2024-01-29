package com.jamersc.springboot.todoexpense.rest;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world!";
    }
}
