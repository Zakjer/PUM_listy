package com.example.login_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.login_app.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentThirdBinding.inflate(layoutInflater)

        binding.registerError.text = ""

        binding.registerButton.setOnClickListener{
            val userName = binding.loginField.text.toString()
            val userPassword = binding.passwordField.text.toString()
            val userRepeated = binding.repatpasswordField.text.toString()

            if (userName.isEmpty() || userPassword.isEmpty() || userRepeated.isEmpty()) {
                binding.registerError.text = "Pola nie mogą być puste"
                return@setOnClickListener
            }

            if (userPassword != userRepeated) {
                binding.registerError.text = "Hasła się nie zgadzają"
                return@setOnClickListener
            }

            else {
                DataProvider.users.add(User(userName, userPassword))
                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment2(userName)
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
        return binding.root
    }
}