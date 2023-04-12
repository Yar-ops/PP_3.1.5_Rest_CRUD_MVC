package ru.kata.spring.boot_security.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.spring.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
}