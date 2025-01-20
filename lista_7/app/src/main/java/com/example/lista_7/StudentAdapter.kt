package com.example.lista_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(
    private val students: List<Student>,
    private val onStudentClicked: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val indexNumber: TextView = view.findViewById(R.id.textIndexNumber)
        val name: TextView = view.findViewById(R.id.textName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.indexNumber.text = student.indexNumber
        holder.name.text = "${student.firstName} ${student.lastName}"

        holder.itemView.setOnClickListener {
            onStudentClicked(student)
        }
    }

    override fun getItemCount(): Int = students.size
}