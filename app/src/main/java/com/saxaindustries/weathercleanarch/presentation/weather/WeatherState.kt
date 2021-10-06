package com.saxaindustries.weathercleanarch.presentation.weather

import com.saxaindustries.weathercleanarch.domain.model.Weather

data class WeatherState (
    val isLoading: Boolean = false,
    val data: Weather? = null,
    val error: String = ""
)
