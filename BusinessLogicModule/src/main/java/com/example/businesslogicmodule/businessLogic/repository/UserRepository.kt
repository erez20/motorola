package com.example.businesslogicmodule.businessLogic.repository

import androidx.lifecycle.LiveData
import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity

class UserRepository(private val persistenceBoundary: PersistenceBoundary) {

    val users: LiveData<List<UserBusinessLogicEntity>> = persistenceBoundary.allUsers


}