package com.saxaindustries.weathercleanarch.data.api.dto

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)