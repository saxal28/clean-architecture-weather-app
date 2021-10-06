package com.saxaindustries.weathercleanarch.data.api.dto

import com.saxaindustries.weathercleanarch.domain.model.Weather

data class WeatherDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherInfoDto>,
    val wind: Wind
)

private val Double.toFahrenheit get() = (this - 273.15) * 9/5 + 32

val WeatherDto.degreesInFahrenheit get() = main.temp.toFahrenheit

val WeatherDto.toModel get() = Weather(
    city = name,
    temperature = degreesInFahrenheit
)