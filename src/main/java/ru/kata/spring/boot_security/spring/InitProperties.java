package ru.kata.spring.boot_security.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.spring.model.Role;
import ru.kata.spring.boot_security.spring.model.User;
import ru.kata.spring.boot_security.spring.service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitProperties {

    private final UserServiceImp userService;

    @Autowired
    public InitProperties(UserServiceImp userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        User user = userService.getByeMail("admin@mail.ru");
        if (user == null) {
            Role userRole = new Role("ROLE_USER");
            Role adminRole = new Role("ROLE_ADMIN");
            List<Role> adminRoles = new ArrayList<>();
            //Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(userRole);
            adminRoles.add(adminRole);
            //admin.setRoles(adminRoles);
            User admin = new User(adminRoles, "Vasya", "Ivanov", 20, "admin@mail.ru", "admin", "admin");
            userService.addUser(admin);
        }
    }
}