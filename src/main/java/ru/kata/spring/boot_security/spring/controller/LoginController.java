package ru.kata.spring.boot_security.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.spring.service.UserService;

@Controller
public class LoginController {

    /*private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }*/

    @GetMapping
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
