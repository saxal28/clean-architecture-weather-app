package com.saxaindustries.weathercleanarch.data.api

import com.saxaindustries.weathercleanarch.data.api.dto.WeatherDto
import com.saxaindustries.weathercleanarch.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeather(zipCode: Int): WeatherDto {
        return api.getWeatherByZipCode(zipCode)
    }
}