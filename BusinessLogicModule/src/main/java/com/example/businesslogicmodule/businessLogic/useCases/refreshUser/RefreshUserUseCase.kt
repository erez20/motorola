package com.example.businesslogicmodule.businessLogic.useCases.refreshUser

import com.example.businesslogicmodule.businessLogic.boundaries.DataSourceBoundary
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary

class RefreshUserUseCase(
    private val dataSourceBoundary: DataSourceBoundary,
    private val persistenceBoundary: PersistenceBoundary
) : RefreshUserUseCaseBoundary(){

    @Throws(Exception::class)
    override suspend fun execute(amount: Int) {
        persistenceBoundary.deleteAllUsers()
        val nextUsers = dataSourceBoundary.getNextUsers(amount)
        persistenceBoundary.storeUserList(nextUsers)
    }



}