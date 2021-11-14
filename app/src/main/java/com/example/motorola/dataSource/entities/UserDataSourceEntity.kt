package com.example.motorola.dataSource.entities

import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity

class UserDataSourceEntity (
    val firstName: String,
    val lastName: String,
    val email: String,
    val pictureLink: String
)

fun UserDataSourceEntity.asUserBusinessLogicEntity() : UserBusinessLogicEntity {
    return UserBusinessLogicEntity(
        firstName = this.firstName,
        lastName  = this.lastName,
        email = this.email,
        pictureLink = this.pictureLink
    )
}