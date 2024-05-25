package com.felipe.passada.navakotlin.respository

import com.felipe.passada.navakotlin.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>{
}