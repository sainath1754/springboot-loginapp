//Maps to DB table
package com.example.loginapp.entity;

import jakarta.persistence.*;

@Entity                       // Marks this class as a JPA entity (maps to a DB table)
@Table(name = "users")        // Maps to the "users" table in MySQL
public class User {

    @Id                                                    // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Auto-increment
    private Long id;

    @Column(nullable = false, unique = true)   // NOT NULL + UNIQUE constraint
    private String username;

    @Column(nullable = false)
    private String password;

    // ── Constructors ────────────────────────────────────────
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // ── Getters & Setters ───────────────────────────────────
    public Long getId()                    { return id; }
    public void setId(Long id)             { this.id = id; }

    public String getUsername()            { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword()            { return password; }
    public void setPassword(String password) { this.password = password; }
}