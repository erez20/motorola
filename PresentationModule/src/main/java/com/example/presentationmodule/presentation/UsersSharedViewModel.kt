package com.example.presentationmodule.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UsersSharedViewModel(private val userRepository: UserRepository): ViewModel() {
    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.initNextUsers(15).toString()
            }
        }
    }
}