package com.example.list_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.list_3.databinding.WordListItemBinding

class WordListAdapter(
    private val subjectList: List<Subject>,
    private val onItemClick: (Subject) -> Unit
) : RecyclerView.Adapter<WordListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WordListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.bind(subject)
    }

    override fun getItemCount(): Int = subjectList.size

    inner class ViewHolder(private val binding: WordListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subject: Subject) {
            binding.singleWord.text = subject.name
            binding.singlGrade.text = subject.grade
            binding.listNumber.text = subject.list
            binding.exerciseNumber.text = subject.exercise

            itemView.setOnClickListener {
                when (subject.name) {
                    "Matematyka" -> itemView.findNavController()
                        .navigate(R.id.action_ListaFragment_to_MatematykaFragment)
                    else -> onItemClick(subject)
                }
            }
        }
    }
}
