// GradeAdapter.kt
package com.example.lista_8.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_8.model.Grade
import com.example.lista_8.databinding.ItemGradeBinding

class GradeAdapter(private val onClick: (Grade) -> Unit) :
    ListAdapter<Grade, GradeAdapter.GradeViewHolder>(GradeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeViewHolder {
        val binding = ItemGradeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GradeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GradeViewHolder, position: Int) {
        val grade = getItem(position)
        holder.bind(grade)
    }

    inner class GradeViewHolder(private val binding: ItemGradeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(grade: Grade) {
            binding.grade = grade
            binding.root.setOnClickListener {
                onClick(grade)
            }
        }
    }
}

class GradeDiffCallback : DiffUtil.ItemCallback<Grade>() {
    override fun areItemsTheSame(oldItem: Grade, newItem: Grade): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Grade, newItem: Grade): Boolean {
        return oldItem == newItem
    }
}
