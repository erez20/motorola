package com.example.datasourcemodule.dataSource.dataSourceClients.randomUser.randomUserEntities

import com.example.datasourcemodule.dataSource.entities.UserDataSourceEntity
import com.squareup.moshi.Json

data class RandomUserResult(
    val results: List<RandomUserUser>
)

data class RandomUserUser(
    val name: RandomUserName,
    val picture: RandomUserPicture,
    val email: String,
    val dob: DateOfBirth
)

data class RandomUserPicture (
    @Json(name = "medium") val mediumPicture:  String
    )

data class RandomUserName(
    val first: String,
    val last: String
)

data class DateOfBirth(
    val date: String
)
fun List<RandomUserUser>.asUserDataSourceEntities() : List<UserDataSourceEntity> {
    return this.map { randomMeUser ->
     UserDataSourceEntity(
         firstName = randomMeUser.name.first,
         lastName = randomMeUser.name.last,
         pictureLink = randomMeUser.picture.mediumPicture,
         email = randomMeUser.email,
         timeOfBirth = randomMeUser.dob.date
     )
    }
}






