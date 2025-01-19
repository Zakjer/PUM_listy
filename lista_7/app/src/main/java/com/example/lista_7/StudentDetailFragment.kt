package com.example.lista_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.lista_7.databinding.FragmentStudentDetailBinding

class StudentDetailFragment : Fragment() {

    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Zainicjuj binding
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)

        // Pobierz studenta z argumentów
        val student = arguments?.getParcelable<Student>("student")

        // Jeśli student jest dostępny, wyświetl jego dane
        student?.let {
            binding.textIndexNumber.text = "Nr indeksu: ${it.indexNumber}"
            binding.textFirstName.text = "Imię: ${it.firstName}"
            binding.textLastName.text = "Nazwisko: ${it.lastName}"
            binding.textAverageGrade.text = "Średnia ocen: ${it.averageGrade}"
            binding.textYear.text = "Rok studiów: ${it.year}"
        }

        return binding.root
    }
}





