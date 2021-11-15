package com.example.persistencemodule.database.entities.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("select * from user")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM user")
    fun rowCount() : Int

}
