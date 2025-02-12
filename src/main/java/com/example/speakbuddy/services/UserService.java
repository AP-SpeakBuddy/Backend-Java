package com.example.speakbuddy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.speakbuddy.data_objects.AuthData;
import com.example.speakbuddy.data_objects.UserData;
import com.example.speakbuddy.repositories.UserRepository;

/**
 * This class handles user functionalities.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserData> getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public Optional<UserData> authUser(AuthData authData) {
        return userRepository.authUser(authData);
    }

    public UserData addUser(UserData userData) {
        return userRepository.addUser(userData);
    }
}
