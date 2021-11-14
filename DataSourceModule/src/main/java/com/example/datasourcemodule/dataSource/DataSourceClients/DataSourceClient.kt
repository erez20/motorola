package com.example.datasourcemodule.dataSource.DataSourceClients

import com.example.datasourcemodule.dataSource.entities.UserDataSourceEntity


interface DataSourceClient {
    suspend fun getNextUsers(amount: Int): List<UserDataSourceEntity>
}