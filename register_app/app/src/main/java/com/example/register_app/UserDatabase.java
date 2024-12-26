package com.example.register_app;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static UserDatabase instance;
    private final List<User> users;

    private UserDatabase() {
        users = new ArrayList<>();
        // Dodanie 5 użytkowników
        users.add(new User("user1", "pass1"));
        users.add(new User("user2", "pass2"));
        users.add(new User("user3", "pass3"));
        users.add(new User("user4", "pass4"));
        users.add(new User("user5", "pass5"));
    }

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public boolean registerUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Użytkownik już istnieje
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public boolean validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
