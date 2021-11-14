package com.example.presentationmodule.presentation.entities

import com.example.motorola.businessLogic.entities.UserBusinessLogicEntity

data class UserPresentationEntity(
    val fullName : String,
    val email: String,
    val picture : String
)

fun UserBusinessLogicEntity.asPresentationEntity() : UserPresentationEntity {
    return UserPresentationEntity(
        fullName  = "$firstName $lastName",
        email = email,
        picture = pictureLink
    )
}