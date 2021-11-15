package com.example.persistencemodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity
import com.example.persistencemodule.database.room.UserDao
import com.example.persistencemodule.database.room.asBusinessLogicEntities
import com.example.persistencemodule.database.room.asDatabaseEntities

class PersistenceBoundaryImpl(private val userDao: UserDao) : PersistenceBoundary() {

    override val allUsers: LiveData<List<UserBusinessLogicEntity>>
        get() = Transformations.map(userDao.getUsers()) { databaseUserList ->
            databaseUserList.asBusinessLogicEntities()
        }

    override suspend fun storeUserList(users: List<UserBusinessLogicEntity>) {

        userDao.insertAll(*users.asDatabaseEntities())
    }

    override suspend fun deleteAllUsers() {
        return userDao.deleteAll()
    }

}