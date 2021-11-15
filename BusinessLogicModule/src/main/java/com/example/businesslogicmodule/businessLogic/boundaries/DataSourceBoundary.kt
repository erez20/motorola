package com.example.businesslogicmodule.businessLogic.boundaries

import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity

interface DataSourceBoundary {
    suspend fun getNextUsers(amount : Int): List<UserBusinessLogicEntity>
}