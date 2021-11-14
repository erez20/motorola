package com.example.persistencemodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.businesslogicmodule.businessLogic.boundaries.PersistenceBoundary
import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity
import com.example.persistencemodule.database.entities.room.UserDao
import com.example.persistencemodule.database.entities.room.asBusinessLogicEntities
import com.example.persistencemodule.database.entities.room.asDatabaseEntities

class PersistenceBoundaryImpl(val userDao: UserDao) : PersistenceBoundary() {

    override val allUsers: LiveData<List<UserBusinessLogicEntity>>
        get() = Transformations.map(userDao.getUsers()) { databaseUserList ->
            databaseUserList.asBusinessLogicEntities()
        }

    override suspend fun storeUserList(users: List<UserBusinessLogicEntity>) {
        userDao.insertAll(*users.asDatabaseEntities())
    }

}