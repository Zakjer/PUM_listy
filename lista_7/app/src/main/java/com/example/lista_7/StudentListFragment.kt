package com.example.lista_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista_7.databinding.FragmentStudentListBinding

class StudentListFragment : Fragment() {

    private lateinit var binding: FragmentStudentListBinding
    private val studentList = listOf(
        Student("10001", "Jan", "Kowalski", 4.5, 3),
        Student("10002", "Anna", "Nowak", 3.8, 2),
        Student("10003", "Piotr", "Wiśniewski", 5.0, 1),
        Student("10004", "Marek", "Lewark", 4.2, 4),
        Student("10005", "Kasia", "Zawisza", 3.9, 2),
        Student("10006", "Tomasz", "Piotrowski", 4.7, 3),
        Student("10007", "Ewa", "Nowicka", 5.0, 1),
        Student("10008", "Adam", "Wojcieszak", 4.3, 4)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setting up the RecyclerView and Adapter
        val adapter = StudentAdapter(studentList) { student ->
            // Passing the selected student object to the StudentDetailFragment
            val action = StudentListFragmentDirections
                .actionStudentListToDetail(student) // Passing the student as an argument
            findNavController().navigate(action)
        }

        // Configuring RecyclerView with Adapter and LayoutManager
        binding.studentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.studentRecyclerView.adapter = adapter
    }
}
