package com.felipe.passada.navakotlin.domain

import jakarta.persistence.*

@Entity
class Address(
    val streetName: String,
    val streetNumber: Number,
    val city: String,
    val state: String,
    val country: String,
    val postalCode: String,
    @OneToOne(mappedBy = "address")
    val user: User? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)

