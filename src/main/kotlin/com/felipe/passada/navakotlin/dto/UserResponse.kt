package com.felipe.passada.navakotlin.dto

import com.felipe.passada.navakotlin.domain.Address
import com.felipe.passada.navakotlin.domain.User
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class Name(
    val title: String,
    val first: String,
    val last: String,
)

@Serializable
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Long,
    val coordinates: Coordinates,
    val timezone: Timezone,
)

@Serializable
data class Street(
    val number: Long,
    val name: String,
)

@Serializable
data class Coordinates(
    val latitude: String,
    val longitude: String,
)

@Serializable
data class Timezone(
    val offset: String,
    val description: String,
)

@Serializable
data class Dob(
    val date: String,
    val age: Long,
)

@Serializable
data class Id(
    val name: String,
    val value: String,
)

@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

@Serializable
data class ResultWrapper(
    val results: List<UserResponse>
)

@Serializable
data class UserResponse(
    val name: Name,
    val location: Location,
    val email: String,
    val dob: Dob,
    val cell: String,
    val id: Id,
    val picture: Picture,
) {
    fun parseToUserDomain(userResp: UserResponse) : User {
       val userAdress = Address(
           userResp.location.street.name,
           userResp.location.street.number,
           userResp.location.city,
           userResp.location.state,
           userResp.location.country,
           userResp.location.postcode.toString()
       )
        val userPicture = com.felipe.passada.navakotlin.domain.Picture(
            userResp.picture.large,
            userResp.picture.medium,
            userResp.picture.thumbnail,
        )

        val parsedUser: User = User(
            userResp.name.first,
            userResp.name.last,
            userResp.email,
            LocalDate.parse(userResp.dob.date, DateTimeFormatter.ISO_DATE_TIME),
            userResp.cell,
            userResp.id.value,
            userAdress,
            userPicture
        )

        return parsedUser
    }
}
