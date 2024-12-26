package com.example.list_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.list_3.databinding.FragmentPUMBinding

class PUM : Fragment() {

    private lateinit var binding: FragmentPUMBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPUMBinding.inflate(inflater, container, false)
        return binding.root
    }

}