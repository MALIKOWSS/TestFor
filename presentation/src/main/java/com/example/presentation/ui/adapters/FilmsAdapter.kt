package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemNameBinding
import com.example.domain.models.ResponseUI

class FilmsAdapter :
    ListAdapter<ResponseUI, FilmsAdapter.AnimeViewHolder>(
        diffUtil
    ) {

    inner class AnimeViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ResponseUI) {
//            Glide.with(binding.imageIcon.context).load(item.attributes.posterImage.original).into(binding.imageIcon)
//            binding.namePerson.text = item.attributes.titles.enJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
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