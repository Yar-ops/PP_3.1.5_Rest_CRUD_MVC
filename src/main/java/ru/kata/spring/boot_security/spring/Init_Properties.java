package ru.kata.spring.boot_security.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.spring.model.Role;
import ru.kata.spring.boot_security.spring.model.User;
import ru.kata.spring.boot_security.spring.service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init_Properties {

    private final UserServiceImp userService;

    @Autowired
    public Init_Properties(UserServiceImp userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        User user = userService.getByeMail("admin@mail.ru");
        if (user == null) {
            User admin = new User("admin@ad", "admin", "Vasya", "Ivanov", 20);
            Role userRole = new Role("ROLE_USER");
            Role adminRole = new Role("ROLE_ADMIN");
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(userRole);
            adminRoles.add(adminRole);
            admin.setRoles(adminRoles);
            userService.addUser(admin);
        }
    }
}