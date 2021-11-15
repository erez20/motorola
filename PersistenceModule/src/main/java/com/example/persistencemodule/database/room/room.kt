package com.example.persistencemodule.database.room


import androidx.room.*
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}



