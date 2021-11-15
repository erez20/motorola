package com.example.businesslogicmodule.businessLogic.repository

import androidx.lifecycle.LiveData
import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity

class UserRepository(private val dataSourceBoundary: DataSourceBoundary, private val persistenceBoundary: PersistenceBoundary) {

    val users: LiveData<List<UserBusinessLogicEntity>> = persistenceBoundary.allUsers

    @Throws(Exception::class)
    suspend fun initWithNewUsers(amount: Int) {
        persistenceBoundary.deleteAllUsers()
        val nextUsers = dataSourceBoundary.getNextUsers(amount)
        persistenceBoundary.storeUserList(nextUsers)
    }

}