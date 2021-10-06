package com.saxaindustries.weathercleanarch.domain.repository

import com.saxaindustries.weathercleanarch.data.api.dto.WeatherDto

interface WeatherRepository {
    suspend fun getWeather(zipCode: Int): WeatherDto
}