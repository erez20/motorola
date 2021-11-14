package com.example.motorola.dependecyInjection.koinModules

import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.datasourcemodule.dataSource.DataSourceBoundaryImpl
import com.example.datasourcemodule.dataSource.DataSourceClients.DataSourceClient
import com.example.datasourcemodule.dataSource.DataSourceClients.RandomUser.RandomUserDataSourceClient
import org.koin.dsl.module

val dataSourceModule = module {
    factory <DataSourceClient> { RandomUserDataSourceClient() }
    factory <DataSourceBoundary> { DataSourceBoundaryImpl(get()) }
}
