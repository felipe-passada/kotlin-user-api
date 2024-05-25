package com.felipe.passada.navakotlin.resource

import com.felipe.passada.navakotlin.domain.User
import com.felipe.passada.navakotlin.dto.ResultWrapper
import com.felipe.passada.navakotlin.dto.UserResponse
import com.felipe.passada.navakotlin.service.UserService
import kotlinx.serialization.json.Json
import org.springframework.data.jpa.repository.Query
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
@RequestMapping("/users")
class UserResource(private val userService: UserService) {
    @GetMapping("/batchPersist")
    suspend fun persistUsers(@RequestParam("batchAmount") batchAmount: Number): ResponseEntity<List<User>> {
        val usersFromApi = userService.fetchUsersFromApi(batchAmount);
        val persistedUsers = userService.batchPersistUsers(usersFromApi)
        return ResponseEntity.ok(persistedUsers)
    }
}