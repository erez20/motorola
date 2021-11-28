package com.example.businesslogicmodule.businessLogic.useCases.initUser

public abstract class InitUserUseCaseBoundary {
    @Throws(Exception::class)
    abstract suspend fun execute(amount: Int)
}
