package com.example.register_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import java.util.ArrayList;
import java.util.List;

public class LoginFragment extends Fragment {

    private List<User> users = new ArrayList<>();

    public LoginFragment() {
        // Generowanie przykładowych użytkowników
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));
        users.add(new User("user5", "password5"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    // Metoda do logowania
    public void onLoginClick(View view) {
        EditText usernameField = getView().findViewById(R.id.username);
        EditText passwordField = getView().findViewById(R.id.password);

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        User user = findUser(username, password);
        if (user != null) {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment);
        } else {
            Toast.makeText(getContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    // Metoda do wyszukiwania użytkownika
    private User findUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
