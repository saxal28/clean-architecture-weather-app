package com.saxaindustries.weathercleanarch.presentation.weather.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}