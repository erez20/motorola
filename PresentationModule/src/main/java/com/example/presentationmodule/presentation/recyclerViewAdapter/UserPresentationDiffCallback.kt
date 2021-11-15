package com.example.presentationmodule.presentation.recyclerViewAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.presentationmodule.presentation.entities.UserPresentationEntity

class UserPresentationDiffCallback : DiffUtil.ItemCallback<UserPresentationEntity>(){

    override fun areItemsTheSame(
        oldItem: UserPresentationEntity,
        newItem: UserPresentationEntity
    ): Boolean {
        return oldItem.email == newItem.email
    }

    override fun areContentsTheSame(
        oldItem: UserPresentationEntity,
        newItem: UserPresentationEntity
    ): Boolean {
        return oldItem == newItem
    }

}