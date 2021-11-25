package com.example.businesslogicmodule.businessLogic.useCases

import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary

class InitUserUseCase(
    private val dataSourceBoundary: DataSourceBoundary,
    private val persistenceBoundary: PersistenceBoundary,
    private val amount: Int //TODO
) : UseCase(){

    @Throws(Exception::class)
    override suspend fun execute() {
        val nextUsers = dataSourceBoundary.getNextUsers(amount)
        persistenceBoundary.storeUserList(nextUsers)
    }
}