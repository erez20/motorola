package com.example.datasourcemodule.dataSource.dataSourceClients

import com.example.datasourcemodule.dataSource.entities.UserDataSourceEntity


interface DataSourceClient {
    suspend fun getNextUsers(amount: Int): List<UserDataSourceEntity>
}