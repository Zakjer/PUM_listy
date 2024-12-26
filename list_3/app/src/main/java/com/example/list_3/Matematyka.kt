package com.example.list_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.list_3.databinding.FragmentMatematykaBinding


class Matematyka : Fragment() {

    private lateinit var binding: FragmentMatematykaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatematykaBinding.inflate(inflater, container, false)
        return binding.root
    }



}
