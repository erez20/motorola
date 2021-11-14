package com.example.datasourcemodule.dataSource.DataSourceClients.RandomUser

import com.example.datasourcemodule.dataSource.RandomUserApi
import com.example.datasourcemodule.dataSource.entities.UserDataSourceEntity
import com.example.datasourcemodule.dataSource.DataSourceClients.DataSourceClient
import com.example.datasourcemodule.dataSource.DataSourceClients.RandomUser.RandomUserEntities.asUserDataSourceEntities

class RandomUserDataSourceClient : DataSourceClient {

    override suspend fun getNextUsers(amount: Int): List<UserDataSourceEntity> {
        val userRandomMeEntities =  RandomUserApi.retrofitService.getUsers(amount)
        return userRandomMeEntities.results.asUserDataSourceEntities()
    }

}