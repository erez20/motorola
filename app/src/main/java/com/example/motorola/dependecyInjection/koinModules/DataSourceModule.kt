package com.example.motorola.dependecyInjection.koinModules

import com.example.motorola.businessLogic.boundaries.DataSourceBoundary
import com.example.motorola.dataSource.DataSourceBoundaryImpl
import com.example.motorola.dataSource.DataSourceClients.DataSourceClient
import com.example.motorola.dataSource.DataSourceClients.RandomUser.RandomUserDataSourceClient
import org.koin.dsl.module

val dataSourceModule = module {
    factory <DataSourceClient> { RandomUserDataSourceClient() }
    factory <DataSourceBoundary> { DataSourceBoundaryImpl(get()) }
}
