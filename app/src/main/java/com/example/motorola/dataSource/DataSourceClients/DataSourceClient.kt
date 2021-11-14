package com.example.motorola.dataSource.DataSourceClients

import com.example.motorola.dataSource.entities.UserDataSourceEntity


interface DataSourceClient {
    suspend fun getNextUsers(amount: Int): List<UserDataSourceEntity>
}