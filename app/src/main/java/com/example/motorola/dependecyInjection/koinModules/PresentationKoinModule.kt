package com.example.motorola.dependecyInjection.koinModules

import com.example.utilsmodule.utils.UsersDateUtils
import com.example.presentationmodule.presentation.UsersSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single <UsersDateUtils> { UsersDateUtils }
    viewModel { UsersSharedViewModel(get(), get()) }

}