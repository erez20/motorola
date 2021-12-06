package com.example.motorola.dependecyInjection.koinModules

import com.example.businesslogicmodule.businessLogic.useCases.initUser.InitUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.refreshUser.RefreshUserUseCase
import com.example.presentationmodule.presentation.buisinessLogicBridge.BusinessLogicBridgeImpl
import com.example.presentationmodule.presentation.buisinessLogicBridge.BusinessLogicBridgeInterface
import com.example.presentationmodule.presentation.sharedViewModel.UsersSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    factory <BusinessLogicBridgeInterface> { BusinessLogicBridgeImpl(
        userRepository = get(),
        usersDateUtils = get(),
        initUserUseCase = get<InitUserUseCase>(),
        refreshUserUseCase = get<RefreshUserUseCase>()
    ) }
    
    viewModel { UsersSharedViewModel(
        blBridge = get())
    }


}