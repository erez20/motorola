package com.example.datasourcemodule.dataSource.entities

import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity

class UserDataSourceEntity (
    val firstName: String,
    val lastName: String,
    val email: String,
    val pictureLink: String,
    val timeOfBirth: String
)

fun UserDataSourceEntity.asUserBusinessLogicEntity() : UserBusinessLogicEntity {
    return UserBusinessLogicEntity(
        firstName = this.firstName,
        lastName  = this.lastName,
        email = this.email,
        pictureLink = this.pictureLink,
        timeOfBirth = this.timeOfBirth
    )
}