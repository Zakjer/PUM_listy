package com.example.list_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.list_3.databinding.FragmentFizykaBinding

class Fizyka : Fragment() {

    private lateinit var binding: FragmentFizykaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFizykaBinding.inflate(inflater, container, false)
        return binding.root
    }

}