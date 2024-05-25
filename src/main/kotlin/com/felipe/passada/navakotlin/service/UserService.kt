package com.felipe.passada.navakotlin.service

import com.felipe.passada.navakotlin.domain.User
import com.felipe.passada.navakotlin.dto.ResultWrapper
import com.felipe.passada.navakotlin.dto.UserResponse
import com.felipe.passada.navakotlin.respository.UserRepository
import kotlinx.serialization.json.Json
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class UserService(
    private final val userRepository: UserRepository,
    private final val webClient: WebClient.Builder,
    private val environment: Environment
) {

    fun getUserById(id: Long): User {
       return userRepository.getReferenceById(id);
    }

    fun fetchUsersFromApi(dataSize: Number? = 10): List<UserResponse> {
        val userApiUrl = environment.getProperty("user.api.url")
        val response = this.webClient.
        baseUrl("$userApiUrl&results=$dataSize")
            .build()
            .get()
            .retrieve()
            .bodyToMono(String::class.java)
            .block()

        val resultWrapper = Json.decodeFromString<ResultWrapper>(response.toString())
        val users = resultWrapper.results
        return users;
    }


    fun batchPersistUsers(users: List<UserResponse>): List<User> {
        val usersToPersist: List<User> = users.map { user -> user.parseToUserDomain(user) }

        return userRepository.saveAll(usersToPersist)
    }

}