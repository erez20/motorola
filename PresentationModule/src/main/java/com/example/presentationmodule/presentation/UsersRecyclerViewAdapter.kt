package com.example.presentationmodule.presentation


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentationmodule.presentation.entities.UserPresentationEntity

class UsersRecyclerViewAdapter(val onItemSelected: (UserPresentationEntity) -> Unit)
    : ListAdapter<UserPresentationEntity, UserViewHolder>(UserPresentationDiffCallback()){

    fun onItemClicked(userPresentationEntity: UserPresentationEntity) {
        onItemSelected(userPresentationEntity)
    }


    fun updateList(it: List<UserPresentationEntity>?) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class UserPresentationDiffCallback() : DiffUtil.ItemCallback<UserPresentationEntity>(){

    override fun areItemsTheSame(
        oldItem: UserPresentationEntity,
        newItem: UserPresentationEntity
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(
        oldItem: UserPresentationEntity,
        newItem: UserPresentationEntity
    ): Boolean {
        TODO("Not yet implemented")
    }

}

class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}
