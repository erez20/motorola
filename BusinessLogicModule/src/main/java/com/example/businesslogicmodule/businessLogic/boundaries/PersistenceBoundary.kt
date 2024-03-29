package com.example.businesslogicmodule.businessLogic.boundaries

import androidx.lifecycle.LiveData
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity

abstract class PersistenceBoundary {
    abstract val allUsers : LiveData<List<UserBusinessLogicEntity>>
    abstract suspend fun storeUserList(users: List<UserBusinessLogicEntity>)
    abstract suspend fun deleteAllUsers()
}