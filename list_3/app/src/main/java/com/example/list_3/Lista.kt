package com.example.list_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list_3.databinding.FragmentListaBinding

class Lista : Fragment() {

    private val subjectList by lazy {
        mutableListOf(
            Subject("Matematyka", "Ocena: 3", "Lista: 3", "Liczba zadań: 3"),
            Subject("Matematyka", "Ocena: 4.5", "Lista: 3", "Liczba zadań: 3"),
            Subject("Fizyka", "Ocena: 5", "Lista: 3", "Liczba zadań: 3"),
            Subject("Fizyka", "Ocena: 5", "Lista: 3", "Liczba zadań: 3"),
            Subject("PUM", "Ocena: 3", "Lista: 3", "Liczba zadań: 3"),
        )
    }

    private lateinit var binding: FragmentListaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = WordListAdapter(subjectList) { subject ->
                if (subject.name == "Matematyka") {
                    findNavController().navigate(R.id.action_ListaFragment_to_MatematykaFragment)
                }
                if (subject.name == "PUM") {
                    findNavController().navigate(R.id.

















                    action_ListaFragment_to_PUMFragment)
                }
                if (subject.name == "Fizyka") {
                    findNavController().navigate(R.id.action_ListaFragment_to_FizykaFragment)
                }

                }
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}