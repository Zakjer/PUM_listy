package com.example.login_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.login_app.databinding.FragmentSecondBinding
import com.example.login_app.databinding.FragmentThirdBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(layoutInflater)

        binding.loginError.text = ""

        binding.loginButton.setOnClickListener{
            val userName = binding.loginField.text.toString()
            val userPassword = binding.passwordField.text.toString()

            if (userName.isEmpty() || userPassword.isEmpty()) {
                binding.loginError.text = "Pola nie mogą być puste"
                return@setOnClickListener
            }

            else {
                DataProvider.users.add(User(userName, userPassword))
                val action = SecondFragmentDirections.actionSecondFragmentToFourthFragment(userName)
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
        return binding.root
    }
}