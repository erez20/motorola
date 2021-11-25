package com.example.motorola.dependecyInjection.koinModules


import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.businesslogicmodule.businessLogic.useCases.InitUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.RefreshUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.UseCase
import org.koin.dsl.module


val businessLoginModule = module {
    factory  { InitUserUseCase(get(),get(), 10) }
    factory  { RefreshUserUseCase(get(),get(), 10) }
    single { UserRepository(get(),get()) }
}
