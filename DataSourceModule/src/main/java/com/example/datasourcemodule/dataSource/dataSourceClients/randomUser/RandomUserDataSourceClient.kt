package com.example.datasourcemodule.dataSource.dataSourceClients.randomUser

import com.example.datasourcemodule.dataSource.RandomUserApi
import com.example.datasourcemodule.dataSource.entities.UserDataSourceEntity
import com.example.datasourcemodule.dataSource.dataSourceClients.DataSourceClient
import com.example.datasourcemodule.dataSource.dataSourceClients.randomUser.randomUserEntities.asUserDataSourceEntities

class RandomUserDataSourceClient : DataSourceClient {

    override suspend fun getNextUsers(amount: Int): List<UserDataSourceEntity> {
        val userRandomMeEntities =  RandomUserApi.retrofitService.getUsers(amount)
        return userRandomMeEntities.results.asUserDataSourceEntities()
    }

}