package com.example.businesslogicmodule.businessLogic.useCases.refreshUser

public abstract class RefreshUserUseCaseBoundary {
    @Throws(Exception::class)
    abstract suspend fun execute(amount: Int)
}
