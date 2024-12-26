package com.example.list_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list_3.databinding.FragmentListyBinding

class Listy : Fragment() {

    private val subjectList by lazy {
        mutableListOf(
            Subject("Matematyka", "Średnia: 3", "Liczba list: 10"),
            Subject("PUM", "Średnia: 4.5",  "Liczba list: 10"),
            Subject("Fizyka", "Średnia: 5", "Liczba list: 10"),
        )
    }

    private lateinit var binding: FragmentListyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListyBinding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = WordListAdapter(subjectList){
                Toast.makeText(requireContext(), "Clicked on ${it.name}", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}