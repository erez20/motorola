package com.example.presentationmodule.presentation

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import com.example.presentationmodule.presentation.entities.asPresentationEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UsersSharedViewModel(private val userRepository: UserRepository): ViewModel() {




    val presentationUsers = Transformations.map(userRepository.users) { userBusinessLogicEntityList ->
        userBusinessLogicEntityList.map { userBusinessLogicEntity ->
            userBusinessLogicEntity.asPresentationEntity()
        }


    }
    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.initNextUsers(15).toString()
            }
        }
    }

    fun itemSelected(userPresentationEntity: UserPresentationEntity) {
        TODO("Not yet implemented")
    }}