package ru.kata.spring.boot_security.spring.service;
import ru.kata.spring.boot_security.spring.model.User;
import java.util.List;

public interface UserService {

    User getByeMail(String eMail);

    User getById(long id);

    List<User> getAllUsers();

    void deleteUser(long id);

    void addUser(User user);

    void editUser(User user);

}
