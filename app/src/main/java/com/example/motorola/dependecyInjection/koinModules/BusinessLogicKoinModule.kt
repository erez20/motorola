package com.example.motorola.dependecyInjection.koinModules


import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.businesslogicmodule.businessLogic.useCases.initUser.InitUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.refreshUser.RefreshUserUseCase
import org.koin.dsl.module


val businessLoginModule = module {
    factory  { InitUserUseCase(get(),get()) }
    factory  { RefreshUserUseCase(get(),get()) }
    single { UserRepository(get()) }
}
