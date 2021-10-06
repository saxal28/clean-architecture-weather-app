package com.saxaindustries.weathercleanarch.data.api

import com.saxaindustries.weathercleanarch.data.api.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("weather?zip={zipCode}&appid=4bd59f1d9351b7167a43254cfc772ef3")
    suspend fun getWeatherByZipCode(@Path("zipCode") zipCode: Int = 62269): WeatherDto
}