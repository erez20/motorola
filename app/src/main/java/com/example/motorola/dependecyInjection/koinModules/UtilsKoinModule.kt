package com.example.motorola.dependecyInjection.koinModules

import com.example.utilsmodule.utils.ShareUtils
import com.example.utilsmodule.utils.UsersDateUtils
import org.koin.dsl.module

val utilsModule = module {
    single<UsersDateUtils> { UsersDateUtils }
    single<ShareUtils> { ShareUtils() }
}
