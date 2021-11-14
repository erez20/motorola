package com.example.motorola.dependecyInjection.koinModules


import android.app.Application
import androidx.room.Room
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary
import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.persistencemodule.PersistenceBoundaryImpl
import com.example.persistencemodule.database.entities.room.UserDB
import com.example.persistencemodule.database.entities.room.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val persistenceModule = module {
    fun provideDataBase(application: Application): UserDB {
        return Room.databaseBuilder(application, UserDB::class.java, "UserDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: UserDB): UserDao {
        return dataBase.userDao()
    }
    single <PersistenceBoundary> { PersistenceBoundaryImpl(get()) }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

}