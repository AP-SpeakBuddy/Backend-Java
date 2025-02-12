package com.example.speakbuddy.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.speakbuddy.data_objects.AuthData;
import com.example.speakbuddy.data_objects.UserData;
import com.example.speakbuddy.services.UserService;

/**
 * This class handles user-related web services.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets user information by ID.
     * @param id The user ID.
     * @return User information.
     */
    @GetMapping("/by_id/{id}")
    public Optional<UserData> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Authenticates a user.
     * @param authData The authentication credentials.
     * @return User data if authentication is successful.
     */
    @PostMapping("/auth")
    public Optional<UserData> authUser(@RequestBody AuthData authData) {
        return userService.authUser(authData);
    }

    /**
     * Registers a new user.
     * @param userData The new user information.
     * @return The created user object.
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserData registerUser(@RequestBody UserData userData) {
        return userService.addUser(userData);
    }
}
