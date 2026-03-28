//Interface (contract)
package com.example.loginapp.service;

import com.example.loginapp.entity.User;

public interface UserService {
    void registerUser(String username, String password);
    boolean existsByUsername(String username);
}