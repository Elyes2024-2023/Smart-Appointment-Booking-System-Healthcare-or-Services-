package com.elyes.advanced.appointment.user.controller;

import com.elyes.advanced.appointment.user.model.User;
import com.elyes.advanced.appointment.user.security.JwtTokenUtil;
import com.elyes.advanced.appointment.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for authentication operations.
 * Handles login and token generation.
 * 
 * @author Elyes
 * @version 1.0
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                         JwtTokenUtil jwtTokenUtil,
                         UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);

        // Update last login time
        userService.findByUsername(userDetails.getUsername())
                .ifPresent(user -> userService.updateLastLogin(user.getId()));

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", userDetails.getUsername());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Check if username or email already exists
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }
}

class LoginRequest {
    private String username;
    private String password;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 