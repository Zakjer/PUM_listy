package com.example.lista_7

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lista_7.databinding.FragmentStudentDetailBinding

class StudentDetailFragment : Fragment() {

    private lateinit var binding: FragmentStudentDetailBinding
    private lateinit var viewModel: StudentDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity())[StudentDetailViewModel::class.java]

        // Retrieve the student index from arguments
        val studentIndex = arguments?.getInt("studentIndex", -1) // Default to -1 if null

        // Log the received index for debugging
        Log.d("StudentDetailFragment", "Received studentIndex: $studentIndex")

        if (studentIndex != null && studentIndex >= 0) {
            try {
                // Retrieve student from ViewModel
                val student = viewModel.getStudent(studentIndex)

                // Update UI with student details
                binding.textIndexNumber.text = "Nr indeksu: ${student.indexNumber}"
                binding.textFirstName.text = "Imię: ${student.firstName}"
                binding.textLastName.text = "Nazwisko: ${student.lastName}"
                binding.textAverageGrade.text = "Średnia ocen: ${student.averageGrade}"
                binding.textYear.text = "Rok studiów: ${student.year}"
            } catch (e: IndexOutOfBoundsException) {
                Log.e("StudentDetailFragment", "Invalid studentIndex: $studentIndex", e)

            }
        } else {
            Log.e("StudentDetailFragment", "Invalid or missing studentIndex: $studentIndex")
        }

        return binding.root
    }
}
