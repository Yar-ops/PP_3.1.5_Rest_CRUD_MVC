package ru.kata.spring.boot_security.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.spring.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.eMail = :eMail")
    User getByeMail(String eMail);
}
