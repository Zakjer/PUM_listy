package com.example.login_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.login_app.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFourthBinding.inflate(layoutInflater)

        val userName = FourthFragmentArgs.fromBundle(requireArguments()).userName

        binding.welcomeMessage.text = "Witaj, $userName!"

        binding.logutButton.setOnClickListener{

            val action = FourthFragmentDirections.actionFourthFragmentToFirstFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return binding.root
    }
}
