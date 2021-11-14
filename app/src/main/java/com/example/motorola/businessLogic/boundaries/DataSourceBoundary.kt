package com.example.motorola.businessLogic.boundaries

import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity

interface DataSourceBoundary {
    suspend fun getNextUsers(amount : Int): List<UserBusinessLogicEntity>
}