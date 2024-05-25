package com.felipe.passada.navakotlin.domain

import jakarta.persistence.*

@Entity
class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
    @OneToOne(mappedBy = "picture")
    val user: User? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

}
