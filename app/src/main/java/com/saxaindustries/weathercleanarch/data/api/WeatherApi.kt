package com.saxaindustries.weathercleanarch.data.api

import com.saxaindustries.weathercleanarch.common.Constants
import com.saxaindustries.weathercleanarch.data.api.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherByZipCode(
        @Query("zip") zip: Int = 62269,
        @Query("appid") appId: String = Constants.API_KEY
    ): WeatherDto
}