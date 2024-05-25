package com.felipe.passada.navakotlin.domain

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="\"user\"")
class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val birthDate: LocalDate,
    val cellPhoneNumber: String,
    val cpf: String,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "address", referencedColumnName = "id")
    val address: Address,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "picture", referencedColumnName = "id")
    val picture: Picture,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
) {
}