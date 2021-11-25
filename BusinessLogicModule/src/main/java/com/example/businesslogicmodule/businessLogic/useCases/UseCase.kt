package com.example.businesslogicmodule.businessLogic.useCases

abstract class UseCase {
    @Throws(Exception::class)
    abstract suspend fun execute()
}
