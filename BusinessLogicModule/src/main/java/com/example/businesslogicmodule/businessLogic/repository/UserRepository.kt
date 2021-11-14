package com.example.businesslogicmodule.businessLogic.repository

import android.util.Log
import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary

class UserRepository(val dataSourceBoundary: DataSourceBoundary) {

    @Throws(Exception::class)
    suspend fun initNextUsers(amount: Int) {
        Log.e("xxxx", dataSourceBoundary.getNextUsers(10).size.toString())
    }
}