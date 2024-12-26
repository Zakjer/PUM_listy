package com.example.list_3

import androidx.recyclerview.widget.RecyclerView
import com.example.list_3.databinding.WordListItemBinding

class WordListViewHolder(
    private val binding: WordListItemBinding,
    onItemClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
        binding.singleWord.text = item
    }

    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }
}