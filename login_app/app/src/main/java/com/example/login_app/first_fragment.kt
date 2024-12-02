package com.example.login_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.login_app.databinding.FragmentFirstFragmentBinding

class first_fragment : Fragment() {

    private lateinit var binding: FragmentFirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstFragmentBinding.inflate(layoutInflater)

        binding.fabB.setOnClickListener {
            val action = first_fragmentDirections.actionFirstFragmentToSecondFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.fabC.setOnClickListener {
            val action = first_fragmentDirections.actionFirstFragmentToThirdFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        return binding.root
    }

}