package com.example.motorola

import android.app.Application
import com.example.motorola.dependecyInjection.koinModules.businessLoginModule
import com.example.motorola.dependecyInjection.koinModules.dataSourceModule
import com.example.motorola.dependecyInjection.koinModules.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MotorolaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidContext(this@MotorolaApplication)
            modules(businessLoginModule, presentationModule, dataSourceModule)
        }
    }
}
