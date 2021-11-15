package com.example.businesslogicmodule.businessLogic.repository

import androidx.lifecycle.LiveData
import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity

class UserRepository(val dataSourceBoundary: DataSourceBoundary, val persistenceBoundary: PersistenceBoundary) {

    val users: LiveData<List<UserBusinessLogicEntity>> = persistenceBoundary.allUsers

    @Throws(Exception::class)
    suspend fun initNextUsers(amount: Int) {
        val x = dataSourceBoundary.getNextUsers(10)
        persistenceBoundary.storeUserList(x)
    }
}