package ru.kata.spring.boot_security.spring.service;

import ru.kata.spring.boot_security.spring.model.Role;
import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role getRoleById(Long id);

}
