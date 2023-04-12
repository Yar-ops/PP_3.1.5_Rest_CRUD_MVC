package ru.kata.spring.boot_security.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.spring.model.Role;
import ru.kata.spring.boot_security.spring.repository.RoleRepository;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }
}
