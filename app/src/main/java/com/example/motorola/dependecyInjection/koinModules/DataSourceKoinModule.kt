package com.example.motorola.dependecyInjection.koinModules

import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.datasourcemodule.dataSource.DataSourceBoundaryImpl
import com.example.datasourcemodule.dataSource.dataSourceClients.DataSourceClient
import com.example.datasourcemodule.dataSource.dataSourceClients.randomUser.RandomUserDataSourceClient
import org.koin.dsl.module

val dataSourceModule = module {
    factory <DataSourceClient> { RandomUserDataSourceClient() }
    factory <DataSourceBoundary> { DataSourceBoundaryImpl(get()) }
}
