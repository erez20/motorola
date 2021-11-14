package com.example.motorola.dataSource.DataSourceClients.RandomUser

import com.example.motorola.dataSource.RandomUserApi
import com.example.motorola.dataSource.entities.UserDataSourceEntity
import com.example.motorola.dataSource.DataSourceClients.DataSourceClient
import com.example.motorola.dataSource.DataSourceClients.RandomUser.RandomUserEntities.asUserDataSourceEntities

class RandomUserDataSourceClient : DataSourceClient {

    override suspend fun getNextUsers(amount: Int): List<UserDataSourceEntity> {
        val userRandomMeEntities =  RandomUserApi.retrofitService.getUsers(amount)
        return userRandomMeEntities.results.asUserDataSourceEntities()
    }

}