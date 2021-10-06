package com.saxaindustries.weathercleanarch.data.api.dto

data class WeatherInfoDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)