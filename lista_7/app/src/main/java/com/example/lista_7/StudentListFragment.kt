package com.example.lista_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista_7.databinding.FragmentStudentListBinding

class StudentListFragment : Fragment() {

    private lateinit var binding: FragmentStudentListBinding
    private val viewModel: StudentDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = StudentAdapter(viewModel.studentList) { student ->
            val studentIndex = student.indexNumber.toInt()
            val action = StudentListFragmentDirections
                .actionStudentListToDetail(studentIndex)
            findNavController().navigate(action)
        }

        binding.studentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.studentRecyclerView.adapter = adapter
    }
}
