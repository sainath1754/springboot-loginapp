//Handles HTTP routes
package com.example.loginapp.controller;

import com.example.loginapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller    // Marks this as a Spring MVC Controller (returns view names, not JSON)
public class AuthController {

    @Autowired
    private UserService userService;

    // ── GET /login → Show Login Page ─────────────────────────
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";    // Resolves to: src/main/resources/templates/login.html
    }

    // ── GET /register → Show Registration Page ───────────────
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // ── POST /register → Handle Registration Form ────────────
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,    // Reads "username" from form input
            @RequestParam String password,    // Reads "password" from form input
            Model model) {                    // Used to send data to the HTML template

        if (userService.existsByUsername(username)) {
            model.addAttribute("error", "Username already taken!");
            return "register";   // Stay on register page, show error
        }

        userService.registerUser(username, password);
        return "redirect:/login?registered=true";   // Redirect to login with success message
    }

    // ── GET /home → Show Home Page (only if logged in) ───────
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}