package com.example.businesslogicmodule.businessLogic.repository

import android.util.Log
import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary

class UserRepository(val dataSourceBoundary: DataSourceBoundary, val persistenceBoundary: PersistenceBoundary) {

    @Throws(Exception::class)
    suspend fun initNextUsers(amount: Int) {
        val x = dataSourceBoundary.getNextUsers(10)
        persistenceBoundary.storeUserList(x)
    }
}