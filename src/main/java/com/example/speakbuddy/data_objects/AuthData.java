package com.example.speakbuddy.data_objects;

/**
 * This class handles user authentication data.
 */
public class AuthData {
    public String email;
    public String password;

    public AuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
