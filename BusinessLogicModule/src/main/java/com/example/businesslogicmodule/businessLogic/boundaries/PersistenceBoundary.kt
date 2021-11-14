package com.example.businesslogicmodule.businessLogic.boundaries

import androidx.lifecycle.LiveData
import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity

abstract class PersistenceBoundary {
    abstract val allUsers : LiveData<List<UserBusinessLogicEntity>>
    abstract suspend fun storeUserList(users: List<UserBusinessLogicEntity>)
}