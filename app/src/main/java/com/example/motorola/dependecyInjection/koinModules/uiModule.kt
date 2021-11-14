package com.example.motorola.dependecyInjection.koinModules

import com.example.motorola.ui.UsersSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    //single<IPresentTaskResponderBoundary> { PresentTaskResponder(get()) }
    //single<IPresentationCoreBridgeFromCore> { PresentationCoreBridgeFromCore() }
    viewModel { UsersSharedViewModel(get()) }

}