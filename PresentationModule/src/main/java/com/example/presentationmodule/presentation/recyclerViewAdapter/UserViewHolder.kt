package com.example.presentationmodule.presentation.recyclerViewAdapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.presentationmodule.databinding.UserListItemBinding
import com.example.presentationmodule.presentation.entities.UserPresentationEntity

class UserViewHolder(
    private val binding: UserListItemBinding,
    onItemClicked: (UserPresentationEntity) -> Unit,
    onItemLongClicked: (UserPresentationEntity) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var currItem: UserPresentationEntity? = null
    init {
        itemClickListener(onItemClicked)
        itemLongClickListener(onItemLongClicked)
    }

    private fun itemLongClickListener(onItemLongClicked: (UserPresentationEntity) -> Unit) {
        binding.root.setOnLongClickListener {
            currItem?.let {
                onItemLongClicked(it)
            }
            return@setOnLongClickListener true
        }
    }

    private fun itemClickListener(onItemClicked: (UserPresentationEntity) -> Unit) {
        binding.root.setOnClickListener {
            currItem?.let {
                onItemClicked(it)
            }
        }
    }

    fun bind(item: UserPresentationEntity) {
        currItem = item
        with(binding) {
            userFullName.text = item.fullName
            userEmail.text = item.email
            Glide.with(itemView.context).load(item.picture).into(userImage)
        }
    }

}