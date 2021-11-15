package com.example.presentationmodule.presentation.entities

import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity
import com.example.utilsmodule.utils.UsersDateUtils

data class UserPresentationEntity(
    val fullName : String,
    val email: String,
    val picture : String,
    val ageInMillis: Long
//    ,
//    val ageByYear: Int
////    ,
//    val ageNumeric: Float,
//    val daysUntilBirthDay:Int
)

fun UserBusinessLogicEntity.asPresentationEntity(userDateUtils: UsersDateUtils): UserPresentationEntity {
    return UserPresentationEntity(
        fullName  = "$firstName $lastName",
        email = email,
        picture = pictureLink,
        ageInMillis = userDateUtils.ageInMilliSec(timeOfBirth)
    )
}

