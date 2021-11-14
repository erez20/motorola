package com.example.businesslogicmodule.businessLogic.boundaries

import androidx.lifecycle.LiveData
import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity

interface PersistenceBoundary {
    suspend fun storeUserList(users: List<UserBusinessLogicEntity>)
    suspend fun getAllUsers() : LiveData<List<UserBusinessLogicEntity>>
}