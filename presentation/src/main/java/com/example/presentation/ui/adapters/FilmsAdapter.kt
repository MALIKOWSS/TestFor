package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemNameBinding
import com.example.presentation.models.ResponseUI

class FilmsAdapter(private val onClickListener: (id: String) -> Unit) :
    ListAdapter<ResponseUI, FilmsAdapter.DetailFilmsViewHolder>(diffUtil) {

    inner class DetailFilmsViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: ResponseUI) {
            binding.originalTitle.text = model.originalTitle
            binding.title.text = model.title
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply { onClickListener(id) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmsAdapter.DetailFilmsViewHolder = DetailFilmsViewHolder(
        ItemNameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: FilmsAdapter.DetailFilmsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseUI>() {
            override fun areItemsTheSame(
                oldItem: ResponseUI,
                newItem: ResponseUI
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseUI,
                newItem: ResponseUI
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}