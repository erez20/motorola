package com.example.presentationmodule.presentation.recyclerViewAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.presentationmodule.databinding.UserListItemBinding
import com.example.presentationmodule.presentation.entities.UserPresentationEntity

class UsersRecyclerViewAdapter(
    val onItemSelected: (UserPresentationEntity) -> Unit,
    val onItemLongSelected: (UserPresentationEntity) -> Unit
):ListAdapter<UserPresentationEntity, UserViewHolder>(UserPresentationDiffCallback()){

    fun updateList(userPresentationEntitiesList: List<UserPresentationEntity>?) {
        submitList(userPresentationEntitiesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding = UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemBinding, ::onItemClicked, ::onItemLongClicked)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    private fun onItemClicked(userPresentationEntity: UserPresentationEntity) {
        onItemSelected(userPresentationEntity)
    }

    private fun onItemLongClicked(userPresentationEntity: UserPresentationEntity) {
        onItemLongSelected(userPresentationEntity)
    }


}

