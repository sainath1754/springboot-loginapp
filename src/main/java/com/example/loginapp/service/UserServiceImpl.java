//Implementation (logic)
package com.example.loginapp.service;

import com.example.loginapp.entity.User;
import com.example.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service    // Marks this as a Spring-managed Service bean (business logic lives here)
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired    // Spring automatically injects the UserRepository bean here
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ── Register a new user ──────────────────────────────────
    @Override
    public void registerUser(String username, String password) {
        String encoded = passwordEncoder.encode(password);  // NEVER store plain text!
        User user = new User(username, encoded);
        userRepository.save(user);
    }

    // ── Check if username already exists ─────────────────────
    @Override
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // ── Spring Security calls this during login ───────────────
    // It loads the user from DB and Spring validates the password
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}