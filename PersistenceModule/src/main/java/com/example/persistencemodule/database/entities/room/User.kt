package com.example.persistencemodule.database.entities.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity

@Entity
data class User constructor(
    @PrimaryKey
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "picture") val pictureLink: String
)

fun User.asBusinessLogicEntity() : UserBusinessLogicEntity {
    return UserBusinessLogicEntity(
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        pictureLink = this.pictureLink
    )
}
fun List<User>.asBusinessLogicEntities(): List<UserBusinessLogicEntity> {
    return map { userDatabaseEntity ->
        userDatabaseEntity.asBusinessLogicEntity()
    }
}


fun List<UserBusinessLogicEntity>.asDatabaseEntities(): Array<User> {
    return this.map {
        User(
            firstName = it.firstName,
            lastName = it.lastName,
            email = it.email,
            pictureLink = it.pictureLink
        )
    }.toTypedArray()
}

