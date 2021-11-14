package com.example.datasourcemodule.dataSource

import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity
import com.example.datasourcemodule.dataSource.entities.asUserBusinessLogicEntity
import com.example.datasourcemodule.dataSource.DataSourceClients.DataSourceClient

class DataSourceBoundaryImpl(private val dataSourceClient: DataSourceClient) : DataSourceBoundary {

    override suspend fun getNextUsers(amount: Int): List<UserBusinessLogicEntity> {
        return dataSourceClient.getNextUsers(amount).map {
            it.asUserBusinessLogicEntity()
        }
    }

}