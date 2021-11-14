package com.example.motorola.dataSource

import com.example.motorola.businessLogic.boundaries.DataSourceBoundary
import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity
import com.example.motorola.dataSource.entities.asUserBusinessLogicEntity
import com.example.motorola.dataSource.DataSourceClients.DataSourceClient

class DataSourceBoundaryImpl(private val dataSourceClient: DataSourceClient) : DataSourceBoundary{

    override suspend fun getNextUsers(amount: Int): List<UserBusinessLogicEntity> {
        return dataSourceClient.getNextUsers(amount).map {
            it.asUserBusinessLogicEntity()
        }
    }

}