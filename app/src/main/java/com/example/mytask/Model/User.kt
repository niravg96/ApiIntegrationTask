package com.example.mytask.Model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val address: Address
)

data class Address(
    val street: String,
    val city: String,
    val zipcode: String
)
