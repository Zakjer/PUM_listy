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

public class RegisterFragment extends Fragment {

    private List<User> users = new ArrayList<>();

    public RegisterFragment() {
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
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    // Metoda do rejestracji nowego użytkownika
    public void onRegisterClick(View view) {
        EditText usernameField = getView().findViewById(R.id.username);
        EditText passwordField = getView().findViewById(R.id.password);

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        if (usernameExists(username)) {
            Toast.makeText(getContext(), "Username already exists", Toast.LENGTH_SHORT).show();
        } else {
            users.add(new User(username, password));
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
        }
    }

    // Sprawdzenie, czy użytkownik o danej nazwie już istnieje
    private boolean usernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Przycisk powrotu do ekranu głównego
    public void onBackToMainClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_mainFragment);
    }
}
