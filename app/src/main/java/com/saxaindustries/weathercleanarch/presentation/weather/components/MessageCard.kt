package com.saxaindustries.weathercleanarch.presentation.weather.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.saxaindustries.weathercleanarch.presentation.weather.WeatherViewModel

@Composable
fun MessageCard(viewModel: WeatherViewModel) {
    val state = viewModel.state.value
    Text(text = "`Weather ${state.data?.temperature} in ${state.data?.city}`")
}