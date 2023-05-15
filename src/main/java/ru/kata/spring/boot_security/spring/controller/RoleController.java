package ru.kata.spring.boot_security.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.spring.model.User;
import ru.kata.spring.boot_security.spring.service.UserService;

import java.security.Principal;

@org.springframework.stereotype.Controller
public class RoleController {

    private final UserService userService;

    @Autowired
    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        User authentificatedUser = userService.getByeMail(principal.getName());
        model.addAttribute("authenticatedUserRoles", authentificatedUser.getRoles());
        return "userPage";
    }

    @GetMapping("/admin")
    public String admin (Model model, Principal principal) {
        User authentificatedUser = userService.getByeMail(principal.getName());
        model.addAttribute("authenticatedUserRoles", authentificatedUser.getRoles());
        return "adminPanel";
    }
}
