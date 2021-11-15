package com.example.motorola

import android.app.Application
import com.example.motorola.dependecyInjection.koinModules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MotorolaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidContext(this@MotorolaApplication)
            modules(
                businessLoginModule,
                presentationModule,
                dataSourceModule,
                persistenceModule,
                utilsModule
            )
        }
    }
}
