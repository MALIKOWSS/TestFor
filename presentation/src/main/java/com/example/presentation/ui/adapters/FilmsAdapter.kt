package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemNameBinding
import com.example.presentation.models.ResponseUI

class FilmsAdapter :
    ListAdapter<ResponseUI, FilmsAdapter.ViewHolder>(
        diffUtil
    ) {

    inner class ViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ResponseUI) {
            binding.title.text = item.title
            binding.originalTitle.text = item.originalTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseUI>() {
            override fun areItemsTheSame(oldItem: ResponseUI, newItem: ResponseUI): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ResponseUI, newItem: ResponseUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}