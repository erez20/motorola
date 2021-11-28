package com.example.businesslogicmodule.businessLogic.useCases.initUser

import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary

class InitUserUseCase(
    private val dataSourceBoundary: DataSourceBoundary,
    private val persistenceBoundary: PersistenceBoundary
) : InitUserUseCaseBoundary(){

    @Throws(Exception::class)
    override suspend fun execute(amount: Int) {
        val nextUsers = dataSourceBoundary.getNextUsers(amount)
        persistenceBoundary.storeUserList(nextUsers)
    }
}