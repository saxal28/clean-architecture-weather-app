package com.saxaindustries.weathercleanarch.domain.model

data class Weather (val city: String, val temperature: Int)

val Weather.displayTemperature get() = "$temperature"
val Weather.uppercaseCity get() = city