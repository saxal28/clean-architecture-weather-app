package com.saxaindustries.weathercleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.saxaindustries.weathercleanarch.presentation.weather.WeatherViewModel
import com.saxaindustries.weathercleanarch.presentation.weather.components.MessageCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(viewModel)
        }
    }
}