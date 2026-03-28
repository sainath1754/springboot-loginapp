//Talks to DB
package com.example.loginapp.repository;

import com.example.loginapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository    // Marks this as a Spring-managed Repository bean
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA auto-generates the SQL for this method!
    // SELECT * FROM users WHERE username = ?
    Optional<User> findByUsername(String username);
}