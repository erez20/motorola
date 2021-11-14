package com.example.motorola.dependecyInjection.koinModules

import com.example.motorola.businessLogic.repository.UserRepository
import org.koin.dsl.module


val businessLoginModule = module {
    single { UserRepository(get()) }
}
