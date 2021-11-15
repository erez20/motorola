package com.example.presentationmodule.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.presentationmodule.databinding.UserListItemBinding
import com.example.presentationmodule.presentation.entities.UserPresentationEntity

class UsersRecyclerViewAdapter(val onItemSelected: (UserPresentationEntity) -> Unit)
    : ListAdapter<UserPresentationEntity, UserViewHolder>(UserPresentationDiffCallback()){

    fun onItemClicked(userPresentationEntity: UserPresentationEntity) {
        onItemSelected(userPresentationEntity)
    }


    fun updateList(userPresentationEntitiesList: List<UserPresentationEntity>?) {
        submitList(userPresentationEntitiesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding = UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemBinding, ::onItemClicked)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class UserPresentationDiffCallback() : DiffUtil.ItemCallback<UserPresentationEntity>(){

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

class UserViewHolder(
    private val binding: UserListItemBinding,
    onItemClicked: (UserPresentationEntity) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var currItem: UserPresentationEntity? = null

    init {
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
            userEmail.text = item.email + item.ageInMillis
            Glide.with(itemView.context).load(item.picture).into(userImage);
        }
    }

}
