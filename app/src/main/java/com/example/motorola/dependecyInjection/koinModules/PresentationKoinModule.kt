package com.example.motorola.dependecyInjection.koinModules

import com.example.businesslogicmodule.businessLogic.useCases.initUser.InitUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.refreshUser.RefreshUserUseCase
import com.example.presentationmodule.presentation.sharedViewModel.UsersSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { UsersSharedViewModel(get(), get(), get<InitUserUseCase>(), get<RefreshUserUseCase>()) }

}